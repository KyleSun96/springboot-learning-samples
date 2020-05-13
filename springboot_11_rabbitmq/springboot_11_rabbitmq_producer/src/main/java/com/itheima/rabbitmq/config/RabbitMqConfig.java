package com.itheima.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: SpringBoot
 * @ClassName: RabbitMqConfig
 * @Description: 配置类
 * 1. 配置交换机
 * 2. 配置队列
 * 3. 绑定队列和交换机
 * @Author: KyleSun
 **/
@Configuration
public class RabbitMqConfig {

    // 交换机名称
    public static final String EXCHANGE_TOPIC = "boot_topic_exchange";
    public static final String EXCHANGE_FANOUT = "boot_fanout_exchange";

    // 队列名称
    public static final String QUEUE_TOPIC = "boot_topic_queue";
    public static final String QUEUE_FANOUT = "boot_fanout_queue";

    // 声明 topic 交换机
    @Bean("bootTopicExchange")
    public Exchange bootTopicExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC).durable(true).build();
    }

    // 声明 fanout 交换机
    @Bean("bootFanoutExchange")
    public Exchange bootFanoutExchange() {
        return ExchangeBuilder.fanoutExchange(EXCHANGE_FANOUT).durable(true).build();
    }

    // 声明 topic 队列
    @Bean("bootTopicQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_TOPIC).build();
    }

    // 声明 fanout 队列
    @Bean("bootFanoutQueue")
    public Queue bootFanoutQueue() {
        return QueueBuilder.durable(QUEUE_FANOUT).build();
    }

    // 绑定队列和交换机 topic
    @Bean
    public Binding bindTopicQueueAndExchange(@Qualifier("bootTopicQueue") Queue queue, @Qualifier("bootTopicExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }

    // 绑定队列和交换机 fanout
    @Bean
    public Binding bindFanoutQueueAndExchange(@Qualifier("bootFanoutQueue") Queue queue, @Qualifier("bootFanoutExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

}
