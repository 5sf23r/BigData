package cn.tedu.service;

import cn.tedu.domain.User;
import cn.tedu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper = null;

    @Transactional
    @Override
    public void regist(User user) {
        System.out.println("UserService..注册..");
        userMapper.insertUser(user);
        //int i = 1/0;
    }
}
