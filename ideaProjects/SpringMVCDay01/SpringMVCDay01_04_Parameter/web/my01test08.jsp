<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my01test08.jsp</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/my01/test08.action" method="post">
        用户名:<input type="text" name="username"/>
        出生日期:<input type="date" name="birthday"/>
        <input type="submit"/>
    </form>
</body>
</html>
