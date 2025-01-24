//package com.test.transactionManagement.product.product;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/product")
//@RequiredArgsConstructor
//public class ProductController {
//
//    private final ProductService productService;
//
//
//
//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Product saveProduct(@RequestBody Product product)throws Exception{
//        Product saveProductData = productService.addProduct(product);
//        return saveProductData;
//    }
//
//}
