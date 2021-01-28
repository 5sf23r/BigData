package cn.tedu.dao;

import cn.tedu.domain.User;

public interface UserDao {
    void addUser(User user);
    User queryUser(int id);
}
