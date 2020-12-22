<%--
  Created by IntelliJ IDEA.
  User: tarena
  Date: 2019/12/22
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSP标签：由sun公司提供，属于jsp规范中的内容，不需要引入第三方标签库，我们介绍其中的三个。</h1>
    <p>
        <jsp:include page="error.jsp"></jsp:include>
    </p>
    <p>
        <jsp:forward page="error.jsp">
            <jsp:param name="username" value="1"></jsp:param>
            <jsp:param name="password" value="2"></jsp:param>
        </jsp:forward>
    </p>
    
</body>
</html>
