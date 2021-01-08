package cn.tedu.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserDao implements UserDao {
    public void addUser() {
        System.out.println("mysql增加用户..");
    }
}
