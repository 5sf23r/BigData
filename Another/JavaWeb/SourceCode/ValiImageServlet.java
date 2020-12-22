package com.easymall.servlet;

import com.easymall.util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ValiImageServlet")
public class ValiImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //控制浏览器不要使用缓存
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-control", "no-cache");
        //生成一张图片
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.drawImage(response.getOutputStream());
        //获取验证码上的文本
        String code = verifyCode.getCode();
        request.getSession().setAttribute("code",code);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
