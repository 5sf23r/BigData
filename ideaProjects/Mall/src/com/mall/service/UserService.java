package com.mall.service;

import com.mall.dao.UserDao;
import com.mall.exception.MsgException;
import com.mall.domain.User;
import com.mall.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;

public class  UserService {
    UserDao userDao = new UserDao();
    /**
     * 注册功能实现
     * @param user 用户信息对象
     */
    public void registUser(User user) {

        boolean flag = userDao.findUserByUsername(user.getUsername());
        //flag为true 则查询到用户名，为false则没有查询到用户
        if(flag){//用户名存在，
            throw new MsgException("用户名已存在");
        }else{//用户名不存在
            userDao.addUser(user);
        }
    }

    public boolean ajaxCheckUsername(String username){
        boolean flag = userDao.findUserByUsername(username);
        return flag;
    }

    public User login(String username,String password){
        //如果用户名和密码匹配，则正常登陆，并跳转到首页
        User user = userDao.findUserByUsernameAndPwd(username, password);
        return user;
    }

}
