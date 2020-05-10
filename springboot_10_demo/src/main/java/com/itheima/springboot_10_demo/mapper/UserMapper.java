package com.itheima.springboot_10_demo.mapper;

import com.itheima.springboot_10_demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: SpringBoot
 * @InterfaceName: UserMapper
 * @Description:
 * @Author: KyleSun
 **/
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from t_user")
    List<User> findAll();
}
