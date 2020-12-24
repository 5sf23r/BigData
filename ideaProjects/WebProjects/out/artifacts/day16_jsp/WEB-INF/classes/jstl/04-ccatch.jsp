<%@ page import="pojo.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
    e=【${e}】<br>

    <c:catch var="e1" >
        <%
            Person p1=null;
            p1.getName();
        %>
    </c:catch>
    e1=【${e1}】<br>
<%-- catch标签：用于捕获异常，能够自动的识别异常的类型，可以打印输出该标签，不常用 --%>
    <hr>
    <br><br><br><br><br>
</body>
</html>
