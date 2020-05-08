package com.itheima.springboot_02_init.controller;

import com.itheima.springboot_02_init.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: SpringBoot
 * @ClassName: HelloController
 * @Description: yaml基本语法
 * @Author: KyleSun
 **/
@RestController
public class HelloController {

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;
    @Value("${person.address[0]}")
    private String address0;
    @Value("${address[1]}")
    private String address1;
    @Value("${msg1}")
    private String msg1;
    @Value("${msg2}")
    private String msg2;
    @Value("${test.msg}")
    private String msg;

    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @RequestMapping("/yaml")
    public void yaml() {

        System.out.println("============测试@value取值============");
        System.out.println(name);
        System.out.println(age);
        System.out.println(address0);
        System.out.println(address1);
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg);

        System.out.println("============测试Environment取值============");
        System.out.println(env.getProperty("person.address[0]"));
        System.out.println(env.getProperty("test.msg"));

        System.out.println("============测试@ConfigurationProperties取值============");
        System.out.println(person);

    }

}
