package com.itheima.delayqueue_producer;

import com.itheima.delayqueue_producer.config.RabbitMqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DelayqueueProducerApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendTest1() throws InterruptedException {

        // 1.发送订单消息。 模拟在订单系统中，下单成功后，发送消息
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_TEST, "test.msg", "延迟队列：模拟10秒后删除订单 ~");

        // 2.打印倒计时10秒
        for (int i = 10; i > 0; i--) {
            System.out.println(i + "...");
            Thread.sleep(1000);
        }
    }

}
