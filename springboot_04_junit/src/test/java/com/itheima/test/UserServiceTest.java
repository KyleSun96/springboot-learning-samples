package com.itheima.test;

import com.itheima.springboottest.SpringbootJunitApplication;
import com.itheima.springboottest.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Program: SpringBoot
 * @ClassName: UserServiceTest
 * @Description: 不在启动类的子包或者同级包下,不能自动扫描,要指定引导类的class字节码文件
 * @Author: KyleSun
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJunitApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.add();
    }

}
