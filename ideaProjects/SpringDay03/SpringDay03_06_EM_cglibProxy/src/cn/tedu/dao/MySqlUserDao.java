package cn.tedu.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class MySqlUserDao implements UserDao {
    public void addUser() {
        System.out.println("mysql增加用户..");
    }

    @Override
    public void updateUser() {
        System.out.println("mysql..修改用户..");
    }

    @Override
    public void deleteUser() {
        System.out.println("mysql..删除用户..");
    }
}
