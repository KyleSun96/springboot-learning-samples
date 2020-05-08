package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: SpringBoot
 * @ClassName: HelloController
 * @Description: SpringBoot快速入门
 * @Author: KyleSun
 **/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello Spring Boot !";
    }
}
