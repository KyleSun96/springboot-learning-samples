package com.itheima.springboot_10_demo.service;

import com.itheima.springboot_10_demo.domain.User;

import java.util.List;

/**
 * @Program: SpringBoot
 * @InterfaceName: UserService
 * @Description:
 * @Author: KyleSun
 **/
public interface UserService {

    List<User> findAll();
}
