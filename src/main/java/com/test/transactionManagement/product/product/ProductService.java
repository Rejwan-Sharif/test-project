package com.test.transactionManagement.product.product;

import com.test.transactionManagement.product.order.Order;
import com.test.transactionManagement.product.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    private final OrderService orderService;

    @Transactional
    public Product addProduct(Product product)throws Exception{
        Product productDao = productRepository.save(product);

        Order order = new Order() ;
//        order.setCustomerName("Rejwan");
//        order.setProduct(product);

        orderService.addOrder(order);
        return productDao;
    }



}
