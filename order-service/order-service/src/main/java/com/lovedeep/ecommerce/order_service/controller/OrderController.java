package com.lovedeep.ecommerce.order_service.controller;



import com.lovedeep.ecommerce.order_service.dto.OrderRequest;
import com.lovedeep.ecommerce.order_service.entity.Order;
import com.lovedeep.ecommerce.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order placeOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }
}
