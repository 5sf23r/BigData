<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSP标签：由sun公司提供，属于jsp规范中的内容，不需要引入第三方标签库，我们介绍其中的三个。</h1>
    <%-- 原生态标签的基本格式：<jsp:标签名></jsp:标签名> --%>
    <p>
        jsp:include:【<jsp:include page="jsp03.jsp"></jsp:include>】
        等价于：request.getRequestDispatcher("/jsp03.jsp").include(request,response)
    </p>
    <p>
        <%-- 页面在进行跳转时，可以携带param参数进行跳转 --%>
    jsp:forward:【<jsp:forward page="jsp03.jsp">】
        jsp:param:【<jsp:param name="username" value="123213"/>】
        【<jsp:param name="password" value="110"/>】
        【</jsp:forward>】
    </p>
</body>
</html>
