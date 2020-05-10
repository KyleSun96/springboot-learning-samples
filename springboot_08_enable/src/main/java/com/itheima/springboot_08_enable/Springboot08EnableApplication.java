package com.itheima.springboot_08_enable;

import com.itheima.config.EnableUser;
import com.itheima.config.MyImportBeanDefinitionRegistrar;
import com.itheima.config.MyImportSelector;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


/**
 * 虽然 pom中添加了 springboot_09_enable_bean 的依赖
 * 但是不能直接获取其中定义的bean
 * 因为 @SpringBootApplication中的 @ComponentScan 扫描范围是当前引导类所在包及其子包
 * <p>
 * 解决方法:
 * 1. @ComponentScan 扫描范围：当前引导类所在包及其子包
 * 2. @Import 可以使用@Import注解，加载类。这些类都会被Spring创建，并放入IOC容器
 * 3. 可以对 @Import 注解进行封装 比如: @EnableUser
 * <p>
 * 此外 @Import 提供4种用法：
 */

//@ComponentScan("com.itheima.config")
//@EnableUser
//@Import(UserConfig.class)
//@Import(User.class)
//@Import(MyImportBeanDefinitionRegistrar.class)
@Import(MyImportSelector.class)
@SpringBootApplication
public class Springboot08EnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot08EnableApplication.class, args);

        User user = context.getBean(User.class);
        System.out.println(user);

        Role role = context.getBean(Role.class);
        System.out.println(role);

    }

}
