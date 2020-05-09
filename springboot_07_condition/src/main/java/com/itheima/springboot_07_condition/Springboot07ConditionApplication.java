package com.itheima.springboot_07_condition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot07ConditionApplication {

    public static void main(String[] args) {
        // 启动SpringBoot的应用,返回Spring的IOC容器
        ConfigurableApplicationContext context = SpringApplication.run(Springboot07ConditionApplication.class, args);

        // 获取bean redisTemplate
        // Object redisTemplate = context.getBean("redisTemplate");
        // System.out.println(redisTemplate);

        Object user = context.getBean("user");
        Object user2 = context.getBean("user2");
        System.out.println(user);
        System.out.println(user2);

    }

}
