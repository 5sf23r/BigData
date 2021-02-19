package com.easymall.service;

import com.easymall.domain.User;

public interface UserService {
    /**
     * 注册用户
     * @param user 封装了用户信息的bean
     */

    public void regist(User user);

    /**
     * 检查用户名是否已经存在
     * @param username 要检查的用户名
     * @return 如果存在返回true，否则false
     */
    boolean hasUserName(String username);

    /**
     * 登陆用户的方法
     * @param username 要登陆的用户名
     * @param password 要登陆的用户名密码
     * @return 如果登陆成功返回bean 如果失败抛出异常
     */
    User login(String username, String password);
}
