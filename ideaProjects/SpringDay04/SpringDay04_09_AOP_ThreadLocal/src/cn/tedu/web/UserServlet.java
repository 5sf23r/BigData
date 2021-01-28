package cn.tedu.web;

import cn.tedu.enums.PrivEnum;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {

    public static PrivEnum role = PrivEnum.USER;

    @Autowired
    private UserService userService = null;

    public void addUser(){
        userService.addUser();
    }
    public void updateUser(){
        userService.updateUser();
    }
    public void queryUser(){
        userService.queryUser();
    }
    public void delUser(){
        userService.delUser();
    }
}
