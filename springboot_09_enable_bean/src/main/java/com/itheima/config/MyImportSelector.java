package com.itheima.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Program: SpringBoot
 * @ClassName: MyImportSelector
 * @Description:
 * @Author: KyleSun
 **/
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 数组中的字符串可以放在 配置文件中,可以获取配置文件数组
        return new String[]{"com.itheima.domain.User", "com.itheima.domain.Role"};
    }
}