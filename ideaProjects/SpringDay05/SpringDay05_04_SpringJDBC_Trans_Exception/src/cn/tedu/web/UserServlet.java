package cn.tedu.web;

import cn.tedu.domain.User;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class UserServlet {

    @Autowired
    private UserService userService = null;

    public void reigistUser(User user){
        try {
            userService.registUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
