package com.example.mqdemo.consumer;

import com.example.mqdemo.config.RabbitMQConfig;
import com.example.mqdemo.model.OrderEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {

    /**
     * Consumer: listens to the order queue. When a message arrives,
     * this method runs. In a real app you might send email, update DB, etc.
     */
    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void handleOrder(OrderEvent order) {
        System.out.println("[CONSUMER] Received from queue: " + order);
        // e.g. notificationService.sendOrderConfirmation(order);
    }
}
