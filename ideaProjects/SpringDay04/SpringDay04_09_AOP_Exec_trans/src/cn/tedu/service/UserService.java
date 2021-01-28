package cn.tedu.service;

import cn.tedu.domain.User;

public interface UserService {
    public void addUser(User user);
    public User queryUser(int id);
}
