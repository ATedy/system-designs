package com.example.mqdemo.producer;

import com.example.mqdemo.config.RabbitMQConfig;
import com.example.mqdemo.model.OrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RabbitTemplate rabbitTemplate;

    public OrderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Producer: accepts an order and publishes it to the message queue.
     * The HTTP response returns immediately; processing happens asynchronously in the consumer.
     */
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderEvent order) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.ORDER_QUEUE, order);
        return ResponseEntity.ok("Order submitted. OrderId: " + order.getOrderId());
    }
}
