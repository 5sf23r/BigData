package cn.tedu.service;

import cn.tedu.dao.UserDao;
import cn.tedu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    //@Transactional
    //@Transactional(rollbackFor = java.io.IOException.class)
    //@Transactional(noRollbackFor = java.lang.NullPointerException.class)
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void registUser(User user) throws IOException  {
        userDao.addUser(user);
        //int i = 1/0;
        throw new IOException();
    }
}
