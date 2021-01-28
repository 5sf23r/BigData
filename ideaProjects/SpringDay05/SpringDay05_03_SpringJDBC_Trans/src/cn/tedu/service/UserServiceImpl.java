package cn.tedu.service;

import cn.tedu.dao.UserDao;
import cn.tedu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    public void registUser(User user) {
        userDao.addUser(user);
        //int i = 1/0;
    }
}
