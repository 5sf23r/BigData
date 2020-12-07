<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>

  <body>
        <h1>c:out标签库 输出</h1>
        <h3>1. 输出常量</h3>
        <c:out value="123"></c:out><br>
        <c:out value="abc"></c:out><br>
        <c:out value="true"></c:out><br>
        <hr>
        <h3>2. 输出变量</h3>
        <%
                int i=10;
                pageContext.setAttribute("j", 20);
        %>
        i=<c:out value="${i}"></c:out><br>
        j=<c:out value="${j}"></c:out><br>
        <hr>
        <h3>3. 转义输出</h3>
        <c:out value="<a href='/day15/index.jsp'>跳转</a>"></c:out><br>
        <c:out value="<a href='/day15/index.jsp'>跳转</a>" escapeXml="false" ></c:out>
        <hr>
        <h3>4. 输出默认值</h3>
        <%
                // pageContext.setAttribute("a",333);
                pageContext.setAttribute("b",666);
        %>
        a=<c:out value="${a}" default="12345" ></c:out><br>
        b=${empty b?"12345":b}
        <hr>
        <br><br><br><br><br>
  </body>
</html>
