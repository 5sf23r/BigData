<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test03.jsp</title>
</head>
<body>
    <h1>GET请求</h1><hr>
    <form action="${pageContext.request.contextPath}/my01/test03.action" method="get">
        用户名:<input type="text" name="username"/>
        密码:<input type="text" name="password"/>
        <input type="submit"/>
    </form>
    <h1>POST请求</h1><hr>
    <form action="${pageContext.request.contextPath}/my01/test03.action" method="post">
        用户名:<input type="text" name="username"/>
        密码:<input type="text" name="password"/>
        <input type="submit"/>
    </form>
</body>
</html>
