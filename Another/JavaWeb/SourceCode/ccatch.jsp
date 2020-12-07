<%@page import="cn.tedu.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>

  <body>
        <h1>c:catch标签 捕获异常</h1>
        <h3>1. 捕获异常</h3>
        <%
                try{
                        int i=10/0;
                }catch(ArithmeticException e){
                        pageContext.setAttribute("e", e);
                }
        %>
        e=${e}<br>

        <c:catch var="e1" >
                <%
                        Person p1=null;
                        p1.getName();
                %>
        </c:catch>
        e1=${e1}<br>

        <hr>
        <br><br><br><br><br>
  </body>
</html>
