package com.test.transactionManagement.product.order;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order addOrder(Order order) throws Exception{

        Order orderDao = orderRepository.save(order);
        return orderDao;
    }

}
