<%--
  Created by IntelliJ IDEA.
  User: tarena
  Date: 2019/12/23
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>c:out标签库 输出</h1>
    <h3>1. 输出常量</h3>
    123:<c:out value="123"></c:out><br>
    abc:<c:out value="abc"></c:out><br>
    true:<c:out value="true"></c:out><br>
    <h3>2. 输出变量</h3>
    <%
        int i=10;
        pageContext.setAttribute("j", 20);
    %>
    i=<c:out value="${i}"></c:out><br>
    j=<c:out value="${j}"></c:out><br>
    <h3>3. 转义输出</h3>
    字符串输出：<c:out value="<a href='/day15/index.jsp'>跳转</a>"></c:out><br>
    超链接：<c:out value="<a href='/day15/index.jsp'>跳转</a>" escapeXml="false" ></c:out><br>
    <h3>4. 输出默认值：default</h3>
    <%
        pageContext.setAttribute("a",333);
        pageContext.setAttribute("b",666);
    %>
    a=<c:out value="${a}" default="123"></c:out>
    b=${empty b?"12345":b}
</body>
</html>
