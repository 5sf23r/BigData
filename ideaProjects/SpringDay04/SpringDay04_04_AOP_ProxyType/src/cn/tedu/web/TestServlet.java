package cn.tedu.web;

import cn.tedu.service.ProdServiceImpl;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestServlet {
    @Autowired
    private UserService userService = null;
    @Autowired
    private ProdServiceImpl prodService = null;

    public void testAdd(){
        System.out.println(userService.getClass());
        System.out.println(prodService.getClass());
    }
}
