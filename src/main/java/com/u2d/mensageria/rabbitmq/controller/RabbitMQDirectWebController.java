package com.u2d.mensageria.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbitmq/direct")
@Slf4j
public class RabbitMQDirectWebController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping()
    public String producer(
            @RequestParam String exchangeName,
            @RequestParam String routingKey,
            @RequestParam String messageData) {
        log.info("Sented msg to rabbitmq");
        amqpTemplate.convertAndSend(exchangeName, routingKey, messageData);

        return "Message sent to the RabbitMQ Successfully";
    }
}
