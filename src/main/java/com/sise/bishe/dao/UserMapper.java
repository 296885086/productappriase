package com.sise.bishe.dao;

import com.sise.bishe.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    @Select("select * from user where username = #{username}")
    User findUserByUsername(@Param("username") String username);

    @Select("select * from user where username = #{username} and email = #{email}")
    User findUserByEmailAndUsername(@Param("username") String username,@Param("email") String email);

    @Select("select * from user where username = #{username} and password = #{password}")
    User findUserByUsernameAndPwd(@Param("username") String username,@Param("password") String password);
}
