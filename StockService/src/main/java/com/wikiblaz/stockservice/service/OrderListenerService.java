package com.wikiblaz.stockservice.service;

import com.example.commercedomain.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderListenerService {

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrder(OrderEvent event) {
        log.info(String.format("Order event received in Stock service => %s", event.getOrder().getId()));
    }
}

