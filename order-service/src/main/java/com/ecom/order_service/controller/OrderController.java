package com.ecom.order_service.controller;

import com.ecom.order_service.dto.OrderRequest;
import com.ecom.order_service.model.Order;
import com.ecom.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody OrderRequest request) {
        System.out.println(request);
        return orderService.placeOrder(
                request.getUserId(),
                request.getProductId(),
                request.getQuantity()
        );

    }
}
