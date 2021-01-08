package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImplStaticProxy implements UserService {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService = null;

    @Override
    public void registUser() {
        try{
            System.out.println("记录日志");
            System.out.println("检查权限");
            System.out.println("开启事务");
            userService.registUser();
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser() {
        try{
            System.out.println("记录日志");
            System.out.println("检查权限");
            System.out.println("开启事务");
            userService.updateUser();
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser() {
        try{
            System.out.println("记录日志");
            System.out.println("检查权限");
            System.out.println("开启事务");
            userService.deleteUser();
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }
}
