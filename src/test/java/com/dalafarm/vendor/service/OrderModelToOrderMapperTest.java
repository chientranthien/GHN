package com.dalafarm.vendor.service;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.frontend.OrderModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by LeeU on 9/3/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderModelToOrderMapperTest {
    @Autowired
    OrderModelToOrderMapper mapper;

    @Test
    public void testMapper() throws IOException {
        String orderModelStr = "{\"id\":\"4CYOAY\",\"info\":{\"name\":\"Vu Test\",\"phone1CountryCode\":\"+84\",\"phone1\":\"+84905551287\",\"verificationCode\":\"\",\"phone2CountryCode\":\"+84\",\"email\":\"\",\"address\":\"Vu test\",\"province\":\"Cà Mau\",\"district\":\"Huyện Năm Căn\",\"paymentType\":\"cod\",\"additionalNote\":\"\",\"districtId\":\"971\"},\"products\":[{\"name\":\"pumpkin\",\"amount\":\"0\",\"price\":87500,\"subtotal\":0},{\"name\":\"moringa\",\"amount\":\"0\",\"price\":65000,\"subtotal\":0},{\"name\":\"tomato\",\"amount\":\"0\",\"price\":119000,\"subtotal\":0},{\"name\":\"carrot\",\"amount\":\"0\",\"price\":119000,\"subtotal\":0},{\"name\":\"heartleaf100\",\"amount\":\"0\",\"price\":165000,\"subtotal\":0},{\"name\":\"heartleaf\",\"amount\":\"0\",\"price\":85000,\"subtotal\":0},{\"name\":\"pennywort100\",\"amount\":\"0\",\"price\":120000,\"subtotal\":0},{\"name\":\"pennywort\",\"amount\":\"0\",\"price\":65000,\"subtotal\":0},{\"name\":\"matcha100\",\"amount\":\"0\",\"price\":175000,\"subtotal\":0},{\"name\":\"matcha\",\"amount\":\"0\",\"price\":95000,\"subtotal\":0},{\"name\":\"cocoa100\",\"amount\":\"0\",\"price\":40000,\"subtotal\":0},{\"name\":\"beetroot\",\"amount\":\"0\",\"price\":100000,\"subtotal\":0},{\"name\":\"broccoli\",\"amount\":\"0\",\"price\":119000,\"subtotal\":0},{\"name\":\"mushroom\",\"amount\":\"0\",\"price\":135000,\"subtotal\":0},{\"name\":\"lotus\",\"amount\":\"0\",\"price\":119000,\"subtotal\":0},{\"name\":\"spinach\",\"amount\":\"0\",\"price\":110000,\"subtotal\":0},{\"name\":\"purpleswpotato\",\"amount\":\"0\",\"price\":85000,\"subtotal\":0},{\"name\":\"garlicoil\",\"amount\":1,\"price\":150000,\"subtotal\":150000},{\"name\":\"dalababy\",\"amount\":\"0\",\"price\":199000,\"subtotal\":0},{\"name\":\"sundetox\",\"amount\":\"1\",\"price\":375000,\"subtotal\":375000},{\"name\":\"moondetox\",\"amount\":\"1\",\"price\":375000,\"subtotal\":375000}],\"meta\":{\"date\":1504410882762},\"promoCode\":\"\",\"subtotal\":800000,\"promotionalProducts\":{\"garlicoilAmt\":1},\"status\":\"Ordered\",\"shippingCost\":50000,\"shippingVendor\":1}";
        ObjectMapper om = new ObjectMapper();

        OrderModel orderModel = om.readValue(orderModelStr, OrderModel.class);

        Order order = mapper.toOrder(orderModel);
        assertNotNull(order);
        assertEquals(order.getOrderDetail().getOrderId(), "4CYOAY");
        assertEquals(order.getOrderDetail().getDropDistrictId(), "971");
        assertEquals(order.getOrderDetail().getToPerson(), "Vu Test");
        assertTrue(Long.compare(order.getOrderDetail().getGrandTotal(), 800000) == 0);
        assertTrue(order.getOrderDetail().isFreeship());
        assertEquals(order.getOrderDetail().getDropTel(), "+84905551287");
        assertEquals(order.getOrderDetail().getFromPerson(), "DalaFarm");
        assertEquals(order.getOrderDetail().getPickupAddress(), "317 Lô D, chung cư Lạc Long Quân, đường Tống Văn Trân");
        assertEquals(order.getOrderDetail().getPickupDistrictId(), "772");
        assertEquals(order.getOrderDetail().getPickupTel(), "0941336174 - 0906951498");
        assertEquals(order.getOrderProducts().size(), 3);
    }
}
