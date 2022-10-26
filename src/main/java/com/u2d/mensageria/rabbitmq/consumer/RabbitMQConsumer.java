package com.u2d.mensageria.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = {"marketingQueue","financeQueue","adminQueue","headerQueue","allQueue","all1Queue"})
    public void recievedMessage(String msg) {
        System.out.println("Recieved Message From RabbitMQ: " + msg);
    }
}
