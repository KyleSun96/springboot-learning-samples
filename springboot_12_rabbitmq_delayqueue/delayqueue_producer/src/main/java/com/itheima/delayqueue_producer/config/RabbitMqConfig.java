package com.itheima.delayqueue_producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: SpringBoot
 * @ClassName: RabbitMqConfig
 * @Description:
 * @Author: KyleSun
 **/
@Configuration
public class RabbitMqConfig {

    // 交换机名称
    public static final String EXCHANGE_TEST = "boot_test_exchange";
    public static final String EXCHANGE_DLX = "boot_dlx_exchange";

    // 队列名称
    public static final String QUEUE_TEST = "boot_test_queue";
    public static final String QUEUE_DLX = "boot_dlx_queue";

    // 声明 正常交换机
    @Bean("boot_test_exchange")
    public Exchange test_exchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TEST).durable(true).build();
    }

    // 声明 死信交换机
    @Bean("boot_dlx_exchange")
    public Exchange dlx_exchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_DLX).durable(true).build();
    }

    // 声明 正常队列，设置正常队列过期时间为 10 秒
    @Bean("boot_test_queue")
    public Queue test_queue() {
        return QueueBuilder.durable(QUEUE_TEST)
                .withArgument("x-message-ttl", 10000)
                .withArgument("x-dead-letter-exchange", "boot_dlx_exchange")
                .withArgument("x-dead-letter-routing-key", "dlx.cancel")
                .build();
    }

    // 声明 死信队列
    @Bean("boot_dlx_queue")
    public Queue dlx_queue() {
        return QueueBuilder.durable(QUEUE_DLX).build();
    }

    // 绑定正常队列和正常交换机
    @Bean
    public Binding bindTestQueueAndExchange(@Qualifier("boot_test_queue") Queue queue, @Qualifier("boot_test_exchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("test.#").noargs();
    }

    // 绑定死信队列和死信交换机
    @Bean
    public Binding bindDLXQueueAndExchange(@Qualifier("boot_dlx_queue") Queue queue, @Qualifier("boot_dlx_exchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("dlx.#").noargs();
    }


}
