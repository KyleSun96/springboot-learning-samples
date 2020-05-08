package com.itheima.springboottest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Program: SpringBoot
 * @ClassName: UserServiceTest
 * @Description: 写在启动类的子包或者同级包下,可以自动扫描,不需要指定引导类的class字节码文件
 * @Author: KyleSun
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.add();
    }

}
