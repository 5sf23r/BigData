<%--
  Created by IntelliJ IDEA.
  User: tarena
  Date: 2019/12/23
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>c:forTokens标签 实现拆分字符串并遍历</h1>
    <%
        String str="1,admin,123,超级管理员,1@163.com";
        pageContext.setAttribute("str", str);
    %>
    <c:forTokens items="${str}" delims="" var="s">
        s=${s}<br>
    </c:forTokens>


    <br><br><br><br><br>
</body>
</html>
