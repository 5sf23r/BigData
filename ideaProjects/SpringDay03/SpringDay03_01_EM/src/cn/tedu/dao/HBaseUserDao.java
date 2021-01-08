package cn.tedu.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class HBaseUserDao implements UserDao {
    @Override
    public void addUser() {
        System.out.println("hbase..增加用户..");
    }
}
