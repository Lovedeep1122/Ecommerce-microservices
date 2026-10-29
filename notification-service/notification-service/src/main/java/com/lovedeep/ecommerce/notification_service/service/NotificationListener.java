package com.lovedeep.ecommerce.notification_service.service;

import com.lovedeep.ecommerce.notification_service.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationListener {

    @KafkaListener(topics = "order-placed", groupId = "notificationId")
    public void handleOrderPlacedEvent(OrderPlacedEvent orderPlacedEvent) {
        // Simulates sending an email/SMS when an order is created
        log.info("Notification sent! Order placed successfully. Order Number: {}", orderPlacedEvent.getOrderNumber());
    }
}