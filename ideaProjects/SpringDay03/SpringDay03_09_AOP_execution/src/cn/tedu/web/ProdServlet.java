package cn.tedu.web;

import cn.tedu.service.aaa.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProdServlet {
    @Autowired
    private ProdService prodService = null;
    public void addProd(){
        prodService.addProd();
    }
    public void delProd(){
        prodService.delProd();
    }
}
