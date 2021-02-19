package com.easymall.mapper;

import com.easymall.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 根据用户名查找用户
     * @param username 要查找的用户名
     * @return 找到用户bean，找不到就返回null
     */
    //@Param("username")强制username赋值到UserMapper.xml中的#{username}上
    User selcUserByUserName(@Param("username") String username);

    /**
     * 新增用户
     * @param user 封装了用户数据的bean
     */
    void insertUser(User user);

    /**
     * 根据用户名密码查找用户
     * @param username
     * @param password
     * @return
     */
    User selcUserByUserNameAndPsw(@Param("username") String username, @Param("password") String password);
}
