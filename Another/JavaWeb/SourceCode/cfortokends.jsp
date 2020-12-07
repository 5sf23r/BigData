<%@page import="cn.tedu.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>

  <body>
        <h1>c:forTokens标签 实现拆分字符串并遍历</h1>
        <%
                String str="1,admin,123,超级管理员,1@163.com";
                pageContext.setAttribute("str", str);
        %>
        <c:forTokens items="${str}" delims="" var="s">
                s=${s}<br>
        </c:forTokens>


        <br><br><br><br><br>
  </body>
</html>
