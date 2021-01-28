<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my01test09.jsp</title>
</head>
<body>
    <h1>文件上传</h1><hr>
    <form action="${pageContext.request.contextPath}/my01/test09.action"
          method="POST"
          enctype="multipart/form-data">
        选择头像:<input type="file" name="fx"/>
        <input type="submit"/>
    </form>
</body>
</html>
