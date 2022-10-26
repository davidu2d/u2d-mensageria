package com.u2d.mensageria.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbitmq/topic")
public class RabbitMQTopicWebController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping
    public String producer(
            @RequestParam String exchangeName,
            @RequestParam String routingKey,
            @RequestParam String messageData) {

        amqpTemplate.convertAndSend(exchangeName, routingKey, messageData);

        return "Message sent to the RabbitMQ Topic Exchange Successfully";
    }

}
