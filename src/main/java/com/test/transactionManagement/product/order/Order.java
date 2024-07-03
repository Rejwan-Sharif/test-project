package com.test.transactionManagement.product.order;


import com.test.transactionManagement.product.product.Product;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String customerName;

    @OneToOne
    private Product product;
}
