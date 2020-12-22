<%@ page import="pojo.Person" %><%--
  Created by IntelliJ IDEA.
  User: tarena
  Date: 2019/12/23
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
