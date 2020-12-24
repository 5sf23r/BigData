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
<%-- 模拟一个场景：登陆之后，显示登陆的名字 --%>
<%-- 如果session中，存在user，显示欢迎回来 --%>
    <c:if test="${not empty sessionScope.user}" var="flag" scope="session" >
        flage=${flag}<br>
        <c:if test="${flag}">
            欢迎：【${sessionScope.user}】回来
        </c:if>
    </c:if>
    <%-- 如果session中，不存在user，显示登陆 --%>
    <c:if test="${empty sessionScope.user}" scope="session" var="flag">
        flag=${flag}<br>
        <c:if test="${flag}">
           <span style="color: red">登陆 | 注册</span>
        </c:if>
    </c:if>
    <hr>
    <br><br><br><br><br>
</body>
</html>
