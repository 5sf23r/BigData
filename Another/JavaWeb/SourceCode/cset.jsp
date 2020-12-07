<%@page import="cn.tedu.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>

  <body>
    <h1>c:set标签 赋值</h1>
    <h3>向四大作用域中增加域属性 page/request/session/application</h3>
        <c:set var="name" value="贾宝玉" scope="request" ></c:set>
        name=${requestScope.name}<br>

    <hr>
    <h3>向map中增加、修改键值对</h3>
    <%
        Map<String,String> map=new HashMap<String,String>();
        map.put("name", "刘备");
        map.put("wife", "甘夫人");
        pageContext.setAttribute("map", map);
    %>
    <!-- 修改键值对的值 -->
    <c:set property="wife" value="孙尚香" target="${map}"></c:set>
    wife=${map["wife"]}<br>
    <!-- 向map集合中添加键值对 -->
    <c:set property="son" value="刘禅" target="${map}"></c:set>
    son=${map["son"]}<br>

    <hr>
    <h3>修改javabean的属性</h3>
    <%
        Person p1=new Person("林黛玉",18,"大观园");
        pageContext.setAttribute("p1", p1);
    %>
    <c:set property="name" value="薛宝钗" target="${p1}" ></c:set>
        p1=${p1}
        <hr>
        <br><br><br><br><br>
  </body>
</html>
