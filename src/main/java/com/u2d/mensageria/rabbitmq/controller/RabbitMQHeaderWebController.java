package com.u2d.mensageria.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq/header")
public class RabbitMQHeaderWebController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping
    public String producer(
            @RequestParam String exchangeName,
            @RequestParam String department,
            @RequestParam String messageData) {

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("department", department);
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message = messageConverter.toMessage(messageData, messageProperties);
        amqpTemplate.send(exchangeName, "", message);

        return "Message sent to the RabbitMQ Header Exchange Successfully";
    }
}