package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FirstController {

    @RequestMapping("/first.action")
    public ModelAndView first(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("k1","vx1");
        mav.addObject("k2","vx2");
        mav.addObject("k3","vx3");
        mav.setViewName("first");
        return mav;
    }

    @RequestMapping("/first2.action")
    public String first2(Model model){
        model.addAttribute("k1","vz1");
        model.addAttribute("k2","vz2");
        model.addAttribute("k3","vz3");
        return "first2";
    }
}
