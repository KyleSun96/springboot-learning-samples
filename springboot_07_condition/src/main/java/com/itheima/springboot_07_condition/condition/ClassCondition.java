package com.itheima.springboot_07_condition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Program: SpringBoot
 * @ClassName: ClassCondition
 * @Description: 自定义动态条件
 * @Author: KyleSun
 **/
public class ClassCondition implements Condition {

    /**
     * @param conditionContext      上下文对象。用于获取环境，IOC容器，ClassLoader对象
     * @param annotatedTypeMetadata 注解元对象。可以用于获取注解定义的属性值
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean flag = true;
        // 得到注解的属性
        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        // 获取 UserConfig 中自定义注解 @ConditionOnClass内的属性值
        String[] value = (String[]) map.get("value");
        for (String className : value) {
            try {
                Class<?> clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                flag = false;
            }
        }
        return flag;
    }
}
