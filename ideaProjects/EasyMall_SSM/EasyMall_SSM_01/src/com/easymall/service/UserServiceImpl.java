package com.easymall.service;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper = null;

    @Override
    public void regist(User user) {
        //1. 检查用户名是否已经存在
        User findUser = userMapper.selcUserByUserName(user.getUsername());
        //2. 存在就抛异常，不存在则新增用户
        if(findUser != null){
            throw new MsgException("用户名已存在");
        }else{
            userMapper.insertUser(user);
        }
    }

    @Override
    public boolean hasUserName(String username) {
        User user = userMapper.selcUserByUserName(username);
        return user!=null;
    }

    @Override
    public User login(String username, String password) {
        //调用dao，根据用户名密码查找用户
        User user = userMapper.selcUserByUserNameAndPsw(username,password);
        if(user!=null) {
            //找到返回用户bean
            return user;
        }else{
            //找不到抛出异常，用户名密码不正确
            throw new MsgException("用户名密码不正确");
        }
    }
}
