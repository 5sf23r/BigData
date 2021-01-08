package cn.tedu.service;

import cn.tedu.dao.MySqlUserDao;
import cn.tedu.dao.OracleUserDao;
import cn.tedu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //private MySqlUserDao userDao = new MySqlUserDao();
    //private OracleUserDao userDao = new OracleUserDao();
    @Autowired
    private UserDao userDao = null;

    public void regist() {
        userDao.addUser();
    }
}
