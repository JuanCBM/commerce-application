package com.wikiblaz.orderservice.controller;

import com.example.commercedomain.dto.Order;
import com.wikiblaz.orderservice.service.OrderProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("${services.url.prefix}/${services.url.version}/orders")
public class OrderController {
    private final OrderProducerService orderProducerService;

    public OrderController(OrderProducerService orderProducerService) {
        this.orderProducerService = orderProducerService;
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        this.orderProducerService.save(order);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();

        return ResponseEntity.created(location).body(order);
    }
}
