package cn.tedu.controller;

import cn.tedu.domain.User;
import cn.tedu.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/regist.action")
    public void regist(User user){
        System.out.println("UserController..注册..");
        userService.regist(user);
    }
}