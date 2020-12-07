<%@page import="cn.tedu.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>

  <body>
    <h1>el功能2：执行运算</h1>
    <h3>算术运算 + - * / %</h3>
    1+1=【】<br>
    12*24=【】<br>
    <!-- el表达式执行算术运算时，会尝试将内容转成数值型，不执行字符串的拼接操作 -->
<%--     1+"a"=${1+"a"}<br> --%>
        <%-- a+b=${"a"+"b"} --%>
        a+b=【】
    <hr>
    <h3>关系运算</h3>
    1&lt;2=【】<br>
    1&gt;2=【】<br>
    <%
        pageContext.setAttribute("p1", new Person());
        pageContext.setAttribute("p2", new Person());
    %>
    p1==p2? 【】
    <hr>
    <h3>逻辑运算 && || ！</h3>
    true&&true= 【】<br>
    false||false=【】<br>
    !true=【】
    <hr>
    <h3>三目运算符 布尔表达式?表达式1:表达式2</h3>
    ${1 lt 2 ? "1 lt 2":"1 gt 2" }
        【】
    <hr>
    <h3>empty运算符</h3>
    <%
        // 判断对象是否为null
        //Person p3=null;
        Person p3=new Person();
        pageContext.setAttribute("p3", p3);
        // 判断字符串是否为空串
        pageContext.setAttribute("str", "");
        // 判断数组是否没有初始化
        String[] array=new String[10];
        pageContext.setAttribute("array",array);
        // 判断集合中没有添加任何元素
        List<String> list=new ArrayList(20);
        // 判断作用域中是否有元素
        // pageScope/requestScope/sessionScope/
        // applicationScope
        // 以上4个对象代表的是四大作用域的集合
        pageContext.setAttribute("list", list);
        // application.setAttribute("123", 123);
        // application.removeAttribute("123");
        // session.setAttribute("111", 111);
        session.removeAttribute("111");

    %>
        判断对象是否为null=【】<br>
    判断字符串是否为空串=【】<br>
    判断数组没有初始化=【】<br>
    判断集合中没有任何元素=【】<br>
    判断作用域中没有任何元素=【】<br>
    <hr>
    <br><br><br><br>
  </body>
</html>
