package com.test.ecommerce.products;

import com.test.ecommerce.vendor.Vendor;
import lombok.Data;

//import javax.persistence.*;

@Data
//@Entity
//@Table(name = "PRODUCTS")
public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
//    @SequenceGenerator(name = "product_seq_gen", sequenceName = "product_seq", allocationSize = 1)
//
//    private Long id;
//    private String name;
//    private String category;
//    private String description;
//    private Double price;
//    private Long quantity;
//
//    @ManyToOne
//    for bidirectional
//    @JoinColumn(name = "vendor_id")
    private Vendor vendor;


}
