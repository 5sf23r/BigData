package cn.tedu.service;

import cn.tedu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    public void registUser() {
        try{
            System.out.println("记录日志..");
            System.out.println("权限控制..");
            System.out.println("开启事务..");
            userDao.addUser();
            System.out.println("提交事务..");
        }catch (Exception e){
            System.out.println("回滚事务..");
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser() {
        try{
            System.out.println("记录日志..");
            System.out.println("权限控制..");
            System.out.println("开启事务..");
            userDao.updateUser();
            System.out.println("提交事务..");
        }catch (Exception e){
            System.out.println("回滚事务..");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser() {
        try{
            System.out.println("记录日志..");
            System.out.println("权限控制..");
            System.out.println("开启事务..");
            userDao.deleteUser();
            System.out.println("提交事务..");
        }catch (Exception e){
            System.out.println("回滚事务..");
            e.printStackTrace();
        }
    }
}
