<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my01test07.jsp</title>
</head>
<body>
    <h1>GET请求</h1><hr>
    <form action="${pageContext.request.contextPath}/my01/test07.action" method="get">
        用户名:<input type="text" name="username"/>
        地址:<input type="text" name="addr"/>
        <input type="submit"/>
    </form>
    <h1>POST请求</h1><hr>
    <form action="${pageContext.request.contextPath}/my01/test07.action" method="post">
        用户名:<input type="text" name="username"/>
        地址:<input type="text" name="addr"/>
        <input type="submit"/>
    </form>
</body>
</html>
