<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>c:choose c:when c:otherwise标签 模拟switch-case</h1>
<%
    pageContext.setAttribute("day", 12);
    int day = 3;
    switch (day){
        case 1:
            System.out.println(1);
%>
<span style="color:red">星期一</span>
<%break;
    case 2:
        System.out.println(2);
        break;
    default:
        System.out.println("非法日期");
}
%>

<c:set var="day" value="12" scope="page"></c:set>
<c:choose>
    <c:when test="${day==1}">
        <span style="color: red">星期一</span>
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
        <span style="color: red">非法星期</span>
    </c:otherwise>
</c:choose>
<hr>
<br><br><br><br><br>
</body>
</html>
