package cn.tedu.web;

import cn.tedu.domain.User;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {

       @Autowired
    private UserService userService = null;

    public void addUser(User user){
        userService.addUser(user);
    }

    public User queryUser(int id){
        return userService.queryUser(id);
    }
}
