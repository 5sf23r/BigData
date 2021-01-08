package cn.tedu.web;

import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {

    @Autowired
    private UserService userService = null;

    public void registUser(){
        userService.registUser();
    }

    public void updateUser(){
        userService.updateUser();
    }

    public void deleteUser(){
        userService.deleteUser();
    }
}
