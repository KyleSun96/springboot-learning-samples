package com.itheima.springbootmybatis.mapper;

import com.itheima.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
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
public interface UserXmlMapper {

    List<User> findAll();
}
