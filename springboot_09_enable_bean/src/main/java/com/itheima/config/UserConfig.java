package com.itheima.config;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: SpringBoot
 * @ClassName: UserConfig
 * @Description: 配置类
 * @Author: KyleSun
 **/
@Configuration
public class UserConfig {

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Role role() {
        return new Role();
    }
}
