package com.itheima.delayqueue_consumer.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Program: SpringBoot
 * @ClassName: RabbitMqListener
 * @Description: 监听队列
 * @Author: KyleSun
 **/
@Component
public class RabbitMqListener {

    // 队列名称，此处我们只监听死信队列，正常队列不需要消费者
    public static final String QUEUE_TEST = "boot_test_queue";
    public static final String QUEUE_DLX = "boot_dlx_queue";

    // 指定监听队列的名称
    @RabbitListener(queues = QUEUE_DLX)
    public void listenerTestQuene(Message message) {
        System.out.println(new String(message.getBody()));
    }

}
