package com.itheima.springbootmybatis;

import com.itheima.springbootmybatis.domain.User;
import com.itheima.springbootmybatis.mapper.UserMapper;
import com.itheima.springbootmybatis.mapper.UserXmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Program: SpringBoot
 * @ClassName: springbootmybatis
 * @Description:
 * @Author: KyleSun
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    public void test01() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test02() {
        List<User> userList = userXmlMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
