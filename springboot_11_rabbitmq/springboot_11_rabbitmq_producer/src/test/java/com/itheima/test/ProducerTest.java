package com.itheima.test;

import com.itheima.rabbitmq.ProducerApplication;
import com.itheima.rabbitmq.config.RabbitMqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Program: SpringBoot
 * @ClassName: ProducerTest
 * @Description:
 * @Author: KyleSun
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend1() {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_TOPIC, "boot.test", "test topic ~~~");
    }

    @Test
    public void testSend2() {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_FANOUT, "", "test fanout ~~~");
    }

}
