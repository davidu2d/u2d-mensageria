package com.u2d.mensageria.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    private static final String ALL_QUEUE = "allQueue";

    private static final String ALL1_QUEUE = "all1Queue";

    private static final String EXCHANGE = "topic.exchange";

    private static final String ROUTING_KEY_ALL = "queue.all";

    private static final String ROUTING_KEY_ALL1 = "queue.*";

    @Bean
    public Queue allQueue() {
        return new Queue(ALL_QUEUE, true);
    }

    @Bean
    public Queue all1Queue() {
        return new Queue(ALL1_QUEUE, true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(allQueue).to(topicExchange).with(ROUTING_KEY_ALL);
    }

    @Bean
    public Binding all1Binding(Queue all1Queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(all1Queue).to(topicExchange).with(ROUTING_KEY_ALL1);
    }
}
