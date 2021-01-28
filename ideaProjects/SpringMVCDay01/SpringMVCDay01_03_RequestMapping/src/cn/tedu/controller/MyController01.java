package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * @RequestMapping的headers属性
     *      要求请求头必须符合指定要求才能访问此控制器方法
     *          格式1:只指定头名称，要求必须具有该名称的请求头
     *          格式2:以"头名称=值"或"名称!=值"的方式指定必须具有某个请求头，且值必须等于或不等于给定值
     *          格式3:以"!头名称"的方式指定必须不包含指定名称的请求头
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test05.action
     */
    @RequestMapping(value="/test05.action",headers={"Cookie","!Refresh","Connection=keep-alive","Host!=localhost"})
    public void test05(){
        System.out.println("test05..");
    }

    /**
     * @RequestMapping的params属性
     *      要求请求参数必须符合指定要求才能访问此控制器方法
     *          格式1:只指定名称，要求必须具有该名称的请求参数
     *          格式2:以"名称=值"或"名称!=值"的方式指定必须具有某个请求参数，且值必须等于或不等于给定值
     *          格式3:以"!名称"的方式指定必须不包含指定名称的请求参数
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test04.action
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test04.action?uname=zs
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test04.action?uname=zs&gender=male
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test04.action?uname=zs&gender=male&country=cn
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test04.action?uname=zs&gender=male&country=us
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test04.action?uname=zs&gender=male&country=us&age=99
     */
    @RequestMapping(value="/test04.action",params={"uname","gender=male","country!=cn","!age"})
    public void test04(){
        System.out.println("test04...");
    }

    /**
     * @RequestMapping的method属性
     *      限定只允许哪种请求方式的请求访问此方法
     *      如果不做配置，所有请求方式都可以访问此控制器方法
     *      可以通过配置method属性限定哪此控制器方法只接受哪些中方式的请求
     * http://localhost/SpringMVCDay01_03_RequestMapping/test03.jsp
     */
    @RequestMapping(value="/test03.action",method=RequestMethod.GET)
    public void test03(){
        System.out.println("test03...");
    }

    /**
     * @RequestMapping的value属性
     *      绑定路径到控制器方法
     *      可以配置多个值，将多个路径绑定到当前方法
     *      可以在路径中使用*号作为通配符
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test02.action
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test02x.action
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test02zabcdefg.action
     */
    @RequestMapping(value={"/test02.action","/test02x.action","/test02z*.action"})
    public void test02(){
        System.out.println("test02...");
    }


    /**
     * @RequestMapping的基本使用
     *      用在方法上 - 将当前方法转为一个控制器方法，绑定到指定路径
     *      用在类上 - 作为当前类中所有控制器方法路径的父路径
     * http://localhost/SpringMVCDay01_03_RequestMapping/my01/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(){
        System.out.println("test01...");
    }
}
