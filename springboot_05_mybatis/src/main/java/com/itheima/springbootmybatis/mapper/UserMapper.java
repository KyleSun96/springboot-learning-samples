package com.itheima.springbootmybatis.mapper;

import com.itheima.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: SpringBoot
 * @InterfaceName: UserMapper
 * @Description: 注解开发
 * @Author: KyleSun
 **/
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from t_user")
    List<User> findAll();
}
