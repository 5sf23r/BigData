<%--
  Created by IntelliJ IDEA.
  User: tarena
  Date: 2019/12/23
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
