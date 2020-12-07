<%@page import="cn.tedu.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>

  <body>
        <h1>c:if标签 执行判断</h1>
    <c:set var="user" value="admin" scope="session"></c:set>
        <c:remove var="user"/>
        <!-- 如果session中有user，显示欢迎。。。回来  -->

        <c:if test="${not (empty sessionScope.user)}" var="flag" scope="page" >
                欢迎XXXX回来...<br>
        </c:if>
        <!-- 如果session中没有user,则显示注册/登录 -->
    <c:if test="${! flag}">
                注册 || 登录
        </c:if>
        <hr>
        <br><br><br><br><br>
  </body>
</html>
