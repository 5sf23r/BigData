package cn.tedu.dao;

import cn.tedu.domain.User;

public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void delUser(int id);
    public User queryUser(int id);
}
