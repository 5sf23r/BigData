<%@page import="cn.tedu.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>

  <body>
        <h1>c:url标签 实现url重写</h1>
        <a href="/day15/index.jsp">超链接1</a><br>
        <a href="<%=response.encodeURL("/day15/index.jsp") %>">超链接2</a><br>
        <a href="<c:url value='/day15/index.jsp' />">超链接3</a><br>
        <br><br><br><br><br>
  </body>
</html>
