<%--
  Created by IntelliJ IDEA.
  User: tarena
  Date: 2019/12/23
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>c:url标签 实现url重写</h1>
    <a href="/day15/index.jsp">超链接1</a><br>
    <a href="<%=response.encodeURL("/day15/index.jsp") %>">超链接2</a><br>
    <a href="<c:url value='/day15/index.jsp' />">超链接3</a><br>
    <br><br><br><br><br>
</body>
</html>
