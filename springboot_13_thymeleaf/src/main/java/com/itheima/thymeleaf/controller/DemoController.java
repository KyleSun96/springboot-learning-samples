package com.itheima.thymeleaf.controller;

import com.itheima.thymeleaf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @Program: SpringBoot
 * @ClassName: DemoController
 * @Description: SpringBoot整合 thymeleaf 的测试工程
 * @Author: KyleSun
 **/
@Controller // 不能使用 @restController，因为此处需要进行页面跳转
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public String test(Model model, String id) {

        // 向demo页面跳转时，使用 Model 携带数据

        // 1. 测试thymeleaf 获取文本数据
        model.addAttribute("test", "hello world");

        // 2. 测试thymeleaf 提交表单
        System.out.println(id);

        // 3. 测试thymeleaf 对象遍历
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "小明", "北京"));
        userList.add(new User(2, "小王", "上海"));
        userList.add(new User(3, "小李", "杭州"));
        model.addAttribute("userList", userList);

        // 4. 测试thymeleaf map取值
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("number", "123");
        dataMap.put("address", "北京");
        model.addAttribute("dataMap", dataMap);

        // 5. 测试thymeleaf 数组遍历
        String[] names = {"小明", "小王", "小李"};
        model.addAttribute("names", names);

        // 6. 测试thymeleaf 日期显示
        model.addAttribute("now", new Date());

        // 7. 测试thymeleaf 条件判断
        model.addAttribute("age", 25);

        /*
         8. 模块声明与页面包含
            见 footer.html
         */

        return "test";
    }
}
