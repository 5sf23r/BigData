<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
        【//功能4 作为域对象使用】
        <%

        %>
        【//功能1 作为入口对象访问其他8大隐式对象】
        <%




        %>

        【//功能2 pageContext操作所有域中属性的方法：setAttribute】
        <%


        %>
        【//功能2 pageContext操作所有域中属性的方法：getAttribute】
        <%

        %>
         【//功能2 pageContext操作所有域中属性的方法：findAttribute】
        <%

        %>
        【//功能2 pageContext操作所有域中属性的方法:removeAttribute】
        <%  %>
         city=<%=pageContext.findAttribute("city") %><br>

        <%   %>
         city=<%=pageContext.findAttribute("city") %><br>

        <%   %>
         city=<%=pageContext.findAttribute("city") %><br>

        <%  %>
         city=<%=pageContext.findAttribute("city") %><br>


        【//功能3 跳转到其他资源】
        <%
                //实现请求转发首页
                pageContext.forward("/index.jsp");
                //request.getRequestDispatcher("/index.jsp").forward(request, response);
        %>



</body>
</html>
