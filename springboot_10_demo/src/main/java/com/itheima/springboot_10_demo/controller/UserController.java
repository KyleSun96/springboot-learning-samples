package com.itheima.springboot_10_demo.controller;

import com.itheima.springboot_10_demo.domain.User;
import com.itheima.springboot_10_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Program: SpringBoot
 * @ClassName: UserController
 * @Description:
 * @Author: KyleSun
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        List<User> userList = userService.findAll();
        System.out.println(userList);
        return userList;
    }

}
