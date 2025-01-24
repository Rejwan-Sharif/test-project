package com.test.ecommerce.orders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Integer id;
    private String orderName;
    private String referenceId;
    private String paymentId;
    private String orderDetails;
}
