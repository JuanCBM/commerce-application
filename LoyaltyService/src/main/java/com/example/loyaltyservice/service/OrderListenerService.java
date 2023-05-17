package com.example.loyaltyservice.service;

import com.example.commercedomain.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderListenerService {

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrder(OrderEvent event) {
        log.info(String.format("Order event received in Loyalty service => %s", event.getOrder().getId()));
    }
}

