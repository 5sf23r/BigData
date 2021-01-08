package cn.tedu.service;

import cn.tedu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    public void registUser() {
        userDao.addUser();
    }

    @Override
    public void updateUser() {
        userDao.updateUser();
    }

    @Override
    public void deleteUser() {
        userDao.deleteUser();
    }
}
