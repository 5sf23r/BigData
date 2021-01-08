package cn.tedu.web;

import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {

    //private UserService userService = new UserService();
    @Autowired
    private UserService userService = null;

    public void regist(){
        userService.regist();
    }
}
