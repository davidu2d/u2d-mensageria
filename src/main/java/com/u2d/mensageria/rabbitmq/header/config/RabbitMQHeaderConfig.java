package com.u2d.mensageria.rabbitmq.header.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

    private static final String HEADER_QUEUE = "headerQueue";

    private static final String EXCHANGE = "header.exchange";

    private static final String HEADER_NAME = "department";

    private static final String HEADER_VALUE = "marketing";

    @Bean
    public Queue headerQueue() {
        return new Queue(HEADER_QUEUE, true);
    }

    @Bean
    public HeadersExchange headerExchange() {
        return new HeadersExchange(EXCHANGE);
    }

    @Bean
    public Binding headerBinding(Queue headerQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(headerQueue).to(headerExchange).where(HEADER_NAME).matches(HEADER_VALUE);
    }
}
