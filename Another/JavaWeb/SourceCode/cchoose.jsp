<%@page import="cn.tedu.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>

  <body>
        <h1>c:choose c:when c:otherwise标签 模拟switch-case</h1>
        <%
                pageContext.setAttribute("day", 12);
        %>

                <c:choose>
                        <c:when test="${day==1}">
                                星期一
                        </c:when>
                        <c:when test="${day==2}">
                                星期二
                        </c:when>
                        <c:when test="${day==3}">
                                星期三
                        </c:when>
                        <c:when test="${day==4}">
                                星期四
                        </c:when>
                        <c:otherwise>
                                其他选项
                        </c:otherwise>
                </c:choose>
        <hr>
        <br><br><br><br><br>
  </body>
</html>
