package com.dalafarm.vendor.service.impl;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.model.ghtk.GhtkOrder;
import com.dalafarm.vendor.model.ghtk.GhtkOrderFeeResponse;
import com.dalafarm.vendor.model.ghtk.GhtkOrderResponse;
import com.dalafarm.vendor.model.ghtk.GhtkOrderStatusResponse;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.repository.StatusRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.dalafarm.vendor.service.StatusMapper;
import com.dalafarm.vendor.util.LogisticBuilder;
import com.dalafarm.vendor.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Date;

/**
 * Created by chien on 8/1/17.
 */
@Service(value = "ghtkService")
public class GhtkService extends AbstractLogisticService {

    private final String PICKUP_PROVINCE = "pick_province";
    private final String PICKUP_DISTRICT = "pick_district";
    private final String DROP_PROVINCE = "province";
    private final String DROP_DISTRICT = "district";
    private final String WEIGHT = "weight";
    private final String TOKEN_HEADER = "Token";

    @Value("${ghtk.url_service}")
    private String urlService;

    @Value("${ghtk.api_token}")
    private String apiToken;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    LogisticBuilder<GhtkOrder> logisticBuilder;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    StatusMapper statusMapper;

    @Autowired
    @Qualifier("tinLogistic")
    LogisticService tinLogisticService;

    @Override
    public OrderFeeResponse calculateServiceFee(OrderSummary orderSummary) {

        URI uri = buildlUri(orderSummary);
        HttpEntity<?> entity = buildHeaderWithToken();

        RestTemplate restTemplate = new RestTemplate();
        GhtkOrderFeeResponse response = restTemplate.exchange(uri,
                HttpMethod.GET,
                entity,
                GhtkOrderFeeResponse.class).getBody();

        if (response.isDeliverable()) {
            return ResponseHelper.buildOrderFeeResponse(response);
        } else {
            return tinLogisticService.calculateServiceFee(orderSummary);
        }
    }

    private URI buildlUri(OrderSummary orderSummary) {
        String url = urlService + "services/shipment/fee";
        District pickupDistrict = districtRepository.findOne(orderSummary.getPickupDistrictId());
        District dropDistrict = districtRepository.findOne(orderSummary.getDropDistrictId());
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam(PICKUP_PROVINCE, pickupDistrict.getProvince().getName())
                .queryParam(PICKUP_DISTRICT, pickupDistrict.getName())
                .queryParam(DROP_PROVINCE, dropDistrict.getProvince().getName())
                .queryParam(DROP_DISTRICT, dropDistrict.getName())
                .queryParam(WEIGHT, orderSummary.getWeight()).build().encode().toUri();
    }

    @Override
    public Response activateOrder(Order order) {

        Response response = activateOrder(order, (o) -> {
            HttpEntity<?> entity = buildEntityForPost(o);
            GhtkOrderResponse ghtkOrder = sendOrderRequestToGhtk(entity);

            Order returnedOrder = ResponseHelper.insertVendorOrderResponseIntoOrder(ghtkOrder, o);
            if (returnedOrder == null) {
                throw new RuntimeException(ghtkOrder.getMessage());
            } else {
                o.setLastModifiedDate(new Date());
                orderRepository.save(o);
            }
        });

        return response;
    }

    @Override
    public Response cancelBookingOrder(Order order) {
        if (order.getOrderDetail().getStatusId().equals(5)) {
            Response response = cancelOrderRequestToGhtk(order.getOrderDetail().getOrderId());
            if(response.isSuccess()){
                order.getOrderDetail().setStatusId(4);
                orderRepository.save(order);
                return response;
            }
        }
        return null;
    }

    private Response cancelOrderRequestToGhtk(String orderId) {
        String url = urlService + "services/shipment/cancel/partner_id:" + orderId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.POST, buildHeaderOnlyEntityForPost(), Response.class).getBody();
    }

    private GhtkOrderResponse sendOrderRequestToGhtk(HttpEntity<?> entity) {
        String url = urlService + "services/shipment/order";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.POST, entity, GhtkOrderResponse.class).getBody();
    }

    private HttpEntity<?> buildEntityForPost(Order order) {
        GhtkOrder ghtkOrder = logisticBuilder.buildOrder(order);

        HttpHeaders headers = new HttpHeaders();
        headers.set(TOKEN_HEADER, apiToken);

        return new HttpEntity<>(ghtkOrder, headers);
    }

    private HttpEntity<?> buildHeaderOnlyEntityForPost() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(TOKEN_HEADER, apiToken);

        return new HttpEntity<>(headers);
    }

    @Override
    public OrderStatusResponse getOrderStatus(String orderId) {
        String url = urlService + "services/shipment/partner_id:" + orderId;
        HttpEntity<?> entity = buildHeaderWithToken();

        RestTemplate restTemplate = new RestTemplate();
        GhtkOrderStatusResponse ghtkOrderStatusResponse = restTemplate.exchange(url,
                HttpMethod.GET,
                entity,
                GhtkOrderStatusResponse.class).getBody();

        OrderStatusResponse orderStatusResponse = ResponseHelper.buildOrderStatusResponse(ghtkOrderStatusResponse);
        orderStatusResponse.setOrderId(orderId);
        orderStatusResponse.setName(statusMapper.mapVendorSpecificStatus(ghtkOrderStatusResponse.getStatus(), orderStatusResponse.getName()));
        return orderStatusResponse;
    }

    private HttpEntity<?> buildHeaderWithToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(TOKEN_HEADER, apiToken);
        return new HttpEntity<>(headers);
    }


}
