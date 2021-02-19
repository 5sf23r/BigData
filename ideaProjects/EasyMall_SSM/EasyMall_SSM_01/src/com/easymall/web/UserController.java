package com.easymall.web;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.service.UserService;
import com.easymall.util.MD5Utils;
import com.easymall.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    @RequestMapping("/logout.action")
    public String logout(HttpSession session,HttpServletResponse response){
        //杀死session，杀死session
        session.invalidate();
        //手动注销，删除30天内自动登录cookie
        Cookie autologinc = new Cookie("autologin","");
        autologinc.setPath("/");
        autologinc.setMaxAge(0);
        response.addCookie(autologinc);
        //重定向回主页
        return "redirect:/index.jsp";
    }
    @RequestMapping("/login.action")
    public String login(String username,String password,String remname,HttpSession session,HttpServletResponse response,Model model) throws UnsupportedEncodingException {
        //1. 获取请求参数中的用户名和密码
        password = MD5Utils.md5(password);
        //2. 处理记住用户名
        //判断用户是否勾选了记住用户名,发送cookie保存用户30天
        if("true".equals(remname)){
            Cookie remnamec = new Cookie("remname", URLEncoder.encode(username,"utf-8"));
            remnamec.setPath("/");
            remnamec.setMaxAge(3600*24*30);
            response.addCookie(remnamec);
        }else{
            //如果没有勾选记住用户名，则删除记住用户名cookie，清除之前保存的用户名
            Cookie remnamec = new Cookie("rename", URLEncoder.encode(username,"utf-8"));
            remnamec.setPath("/");
            remnamec.setMaxAge(0);
            response.addCookie(remnamec);
        }

        //3. 检查用户名密码是否正确
        try {
            User user = userService.login(username,password);
            //   用户名密码正确，登陆用户

            session.setAttribute("user",user);
            //   并处理30天内自动登录,回主页
            Cookie autologinc = new Cookie("autologin",URLEncoder.encode(username,"utf-8")+"#"+password);
            autologinc.setPath("/");
            autologinc.setMaxAge(3600*24*30);
            response.addCookie(autologinc);
            //登陆成功，回主页
            return "redirect:/index.jsp";
        } catch (MsgException e) {
            //用户名密码不正确，回到登陆页面，提示用户
            model.addAttribute("errorMsg",e.getMessage());
            return "forward:/WEB-INF/jsp/login.jsp";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/AjaxCheckUserName.action",produces = "text/html;charset=utf-8")
    public String AjaxCheckUsername(String username){
        if(userService.hasUserName(username)){
            //存在提示用户名不可用
            return "用户名已存在";
        }else{
            //不存在提示用户名可用
            return "用户名可用";
        }
    }
    @RequestMapping("/valiImg.action")
    public void valiImg(HttpServletResponse response, HttpSession session) throws IOException {
        //0. 禁用缓存
        response.setDateHeader("Expires",-1);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        //1. 生成验证码
        VerifyCode verifyCode = new VerifyCode();
        //2. 将验证码图片输出给浏览器
        verifyCode.drawImage(response.getOutputStream());
        //3. 将验证码的值存入session
        String valiStr = verifyCode.getCode();
        session.setAttribute("valistr",valiStr);
    }
    @RequestMapping("/regist.action")
    public String regist(@Validated User user, BindingResult br,Model model, @RequestParam("valistr") String valistr1, @SessionAttribute("valistr") String valistr2){
        //1. 解决乱码
        //2. 验证码校验
        if(valistr1 == null || valistr2 == null || !valistr1.equals(valistr2)){
            model.addAttribute("errMsg","验证码不正确");
            return "forward:/WEB-INF/jsp/regist.jsp";
        }
        //3.数据校验
        if(br.hasErrors()){
            List<ObjectError> errs = br.getAllErrors();
            for(ObjectError err:errs){
                String msg = err.getDefaultMessage();
                System.out.println(msg);
            }
        }
        //4. 获取请求参数封装到bean
        //public String regist(User user){}
        try {
            user.setPassword(MD5Utils.md5(user.getPassword()));
            //5. 调用Service完成注册
            userService.regist(user);
            //6. 成功定时刷新回主页
            return "redirect:/index.jsp";
        }catch (MsgException e){
            //7. 失败则设置错误信息，回到注册页面
            String msg = e.getMessage();
            model.addAttribute("errMsg",e.getMessage());
            return "forward:/WEB-INF/jsp/regist.jsp";
        }
    }
}
