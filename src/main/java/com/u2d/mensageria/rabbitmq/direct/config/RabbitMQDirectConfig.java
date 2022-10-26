package com.u2d.mensageria.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    private static final String MARKETING_QUEUE = "marketingQueue";

    private static final String EXCHANGE = "direct.exchange";

    private static final String ROUTING_KEY = "direct.routingkey";

    @Bean
    public Queue marketingQueue() {
        return new Queue(MARKETING_QUEUE, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding marketingBinding(Queue marketingQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(marketingQueue).to(directExchange).with(ROUTING_KEY);
    }
}
