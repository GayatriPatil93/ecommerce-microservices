package com.ecom.order_service.service;

import com.ecom.order_service.clients.ProductClient;
import com.ecom.order_service.clients.UserClient;
import com.ecom.order_service.dto.ProductDto;
import com.ecom.order_service.dto.UserDto;
import com.ecom.order_service.model.Order;
import com.ecom.order_service.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserClient userClient;

    @CircuitBreaker(name = "productServiceCB", fallbackMethod = "productFallback")
    public Order placeOrder(Long userId, Long productId,Integer quantity){

        UserDto user = userClient.getUserById(userId);

        ProductDto product = productClient.getProductById(productId);

        if( product == null || product.getStock()< quantity){
            throw new RuntimeException("Product out of stock");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(product.getPrice() * quantity);
        order.setStatus("CREATED");

        return orderRepository.save(order);

    }
    public Order productFallback(Long userId, Long productId, Integer quantity, Throwable ex){
        System.out.println("Fallback Executed:" + ex.getMessage());

        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(0.0);
        order.setStatus("FAILED_PRODUCT_SERVICE");

        return order;
    }
}
