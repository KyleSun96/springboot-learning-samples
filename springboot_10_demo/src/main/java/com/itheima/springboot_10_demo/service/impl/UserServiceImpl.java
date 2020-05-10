package com.itheima.springboot_10_demo.service.impl;

import com.itheima.springboot_10_demo.domain.User;
import com.itheima.springboot_10_demo.mapper.UserMapper;
import com.itheima.springboot_10_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: SpringBoot
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: KyleSun
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
