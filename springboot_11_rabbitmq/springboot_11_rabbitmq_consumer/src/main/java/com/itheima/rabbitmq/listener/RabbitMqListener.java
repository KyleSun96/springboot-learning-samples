package com.itheima.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Program: SpringBoot
 * @ClassName: listener
 * @Description: 监听队列
 * @Author: KyleSun
 * @Create: 11:27 2020/5/13
 **/
@Component
public class RabbitMqListener {

    // 队列名称
    public static final String QUEUE_TOPIC = "boot_topic_queue";
    public static final String QUEUE_FANOUT = "boot_fanout_queue";

    // 指定队列的名称
    @RabbitListener(queues = QUEUE_TOPIC)
    public void listenerTopicQuene(Message message) {
        System.out.println(new String(message.getBody()));
    }

    // 指定队列的名称
    @RabbitListener(queues = QUEUE_FANOUT)
    public void listenerFanoutQuene(Message message) {
        System.out.println(new String(message.getBody()));
    }

}
