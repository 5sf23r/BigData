<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>c:remove标签 删除作用域中的值</h1>
    <h3>1. 删除指定作用域中的值</h3>
    <c:set var="city" value="北京" scope="page"></c:set>
    <c:set var="city" value="太原" scope="request"></c:set>
    <c:set var="city" value="石家庄" scope="session"></c:set>
    <c:set var="city" value="青岛" scope="application"></c:set>
    city=${city}<br>
    删除page：【<c:remove var="city" scope="page" ></c:remove>】
    city=${city}<br>
    删除request：【<c:remove var="city" scope="request"></c:remove>】
    city=${city}<br>
    删除session：【<c:remove var="city" scope="session" ></c:remove>】
    city=${city}<br>
    删除application：【<c:remove var="city" scope="application" ></c:remove>】
    city=${city}<br>
    <hr>
    <h3>2. 如果不指定scope，则删除4大作用域中所有该name的值</h3>
    <c:set var="city" value="北京" scope="page"></c:set>
    <c:set var="city" value="太原" scope="request"></c:set>
    <c:set var="city" value="石家庄" scope="session"></c:set>
    <c:set var="city" value="青岛" scope="application"></c:set>
    city=${city}<br>
    删除所有不指定scope：【<c:remove var="city"></c:remove>】
    city=${city}
    <%-- 总结：remove标签：删除域对象中的attribute键值对属性 --%>
    <hr>
    <br><br><br><br><br>
</body>
</html>
