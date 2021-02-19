package com.easymall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    @RequestMapping("/forward/{path}.action")
    public String  forward(@PathVariable("path")String path){
        System.out.println(path);
        return path;
    }
}
