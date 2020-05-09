package com.itheima.springboot_07_condition.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 自定义注解
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ClassCondition.class) // 给自定义注解 提供条件的类
public @interface ConditionOnClass {
    String[] value();
}
