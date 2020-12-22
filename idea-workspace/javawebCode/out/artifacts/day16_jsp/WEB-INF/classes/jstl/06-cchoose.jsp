<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tarena
  Date: 2019/12/23
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>c:choose c:when c:otherwise标签 模拟switch-case</h1>
    <%
        pageContext.setAttribute("day", 12);
    %>
    <c:set var="day" value="12" scope="page"></c:set>

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
