<%--
  Created by IntelliJ IDEA.
  User: tedu
  Date: 2019/12/20
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>1.JSP模板元素</h1>
    <span>JSP页面中的所有的HTML元素，都是会被编译进入 .java文件  </span>
    <span>JSP页面中的所有的CSS+JS+数据，同样会被编译进入 .java文件 </span>
    <span>JSP页面中的所有的模板元素，最后会被编译进入  servlet.java文件 </span>
    <hr>
    <h1>2.JSP的脚本表达式</h1>
    <p>定义一个变量：<% int i = 0; %>  </p>
    <p>常量：<%= 300 %></p>
    <p>变量：<%= i %></p>
</body>
</html>
