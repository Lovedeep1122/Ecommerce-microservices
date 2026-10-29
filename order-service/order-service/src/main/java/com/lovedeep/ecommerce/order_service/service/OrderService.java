package com.lovedeep.ecommerce.order_service.service;

import com.lovedeep.ecommerce.order_service.dto.OrderRequest;
import com.lovedeep.ecommerce.order_service.entity.Order;
import com.lovedeep.ecommerce.order_service.event.OrderPlacedEvent;
import com.lovedeep.ecommerce.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    // These two lines inject your repository and Kafka template
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public Order createOrder(OrderRequest orderRequest) {

        // 1. Create the entity and use Lombok's setters
        Order order = new Order();
        order.setSkuCode(orderRequest.getSkuCode());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());

        String orderNumber = "ORD-" + System.currentTimeMillis();
        order.setOrderNumber(orderNumber);

        // 2. Save to database
        Order savedOrder = orderRepository.save(order);

        // 3. Send message to Kafka
        kafkaTemplate.send("order-placed", new OrderPlacedEvent(orderNumber));

        return savedOrder;
    }
}