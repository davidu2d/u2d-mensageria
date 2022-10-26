package com.u2d.mensageria.rabbitmq.fanout.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    private static final String FINANCE_QUEUE = "financeQueue";

    private static final String ADMIN_QUEUE = "adminQueue";

    private static final String EXCHANGE = "fanout.exchange";

    @Bean
    Queue financeQueue() {
        return new Queue(FINANCE_QUEUE, true);
    }

    @Bean
    public Queue adminQueue() {
        return new Queue(ADMIN_QUEUE, true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    Binding financeBinding(Queue financeQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(financeQueue).to(fanoutExchange);
    }

    @Bean
    Binding adminBinding(Queue adminQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange);
    }

}
