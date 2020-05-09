package com.itheima.springboot_07_condition.config;

import com.itheima.springboot_07_condition.condition.ClassCondition;
import com.itheima.springboot_07_condition.condition.ConditionOnClass;
import com.itheima.springboot_07_condition.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: SpringBoot
 * @ClassName: UserConfig
 * @Description: User的配置类
 * @Author: KyleSun
 **/
@Configuration
public class UserConfig {

    // 使用自定义的注解
    @Bean
    @ConditionOnClass("redis.clients.jedis.Jedis")
    public User user() {
        return new User();
    }


    // 使用系统定义的注解
    @Bean
    @ConditionalOnProperty(name = "username", havingValue = "KyleSun")
    public User user2() {
        return new User();
    }


}
