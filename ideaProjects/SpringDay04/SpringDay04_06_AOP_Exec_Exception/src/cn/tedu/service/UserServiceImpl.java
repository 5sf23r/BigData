package cn.tedu.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("增加用户");
        int i = 1/0;
    }
}
