package cn.tedu.dao;

import org.springframework.stereotype.Repository;

@Repository
public class OracleUserDao implements UserDao{
    public void addUser(){
        System.out.println("oracle..增加用户..");
    }
}
