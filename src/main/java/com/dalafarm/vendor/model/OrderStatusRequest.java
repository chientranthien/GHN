package com.dalafarm.vendor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by LeeU on 9/4/2017.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDER_STATUS_REQUEST")
public class OrderStatusRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @JsonProperty("order_id")
    private String orderId;

    @NotEmpty
    @JsonProperty("vendor_order_id")
    private String vendorOrderId;

    @NotNull
    @JsonProperty("status_id")
    private Integer statusId;

    @JsonProperty("action_time")
    private Date actionTime;

    @JsonProperty("reason_code")
    private String reasonCode;

    private String reason;

    private Float weight;

    @JsonProperty("fee")
    private Integer shippingFee;

    private Date createdDate;

}
