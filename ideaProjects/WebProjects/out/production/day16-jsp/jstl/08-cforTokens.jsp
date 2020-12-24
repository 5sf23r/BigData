<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>c:forTokens标签 实现拆分字符串并遍历</h1>
    <%
        String str="1,admin,123,超级管理员,1@163.com";
        pageContext.setAttribute("str", str);
        String[] split = str.split("");
        for(String ss : split){
            System.out.println(ss);
        }
    %>
    <%-- 特别注意：java代码中的str.split("")表示把每一个字符都拆分出来，标签中：delims=""表示不做任何拆分 --%>
    <c:forTokens items="${str}" delims="" var="ss">
        结果：=${ss}<br>
    </c:forTokens>


    <br><br><br><br><br>
</body>
</html>
