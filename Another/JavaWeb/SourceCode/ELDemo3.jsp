<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>

  <body>
   <h1>EL功能3 获取常用开发对象-11个内置对象</h1>
   <h3>1.pageContext</h3>
        pageContext=【】
   <hr>
   <h3>2.代表了4大作用域上的map集合的4个对象</h3>
        <!-- 4大作用域对象 pageContext,request,session,application -->
        <!-- pageScope/requestScope/sessionScope/applicationScope -->
        <!-- 上面这4个对象本身就是map集合，分别代表了4大作用域对象身上的map集合 -->
   <%
                pageContext.setAttribute("fruit", "apple");
                pageContext.setAttribute("fruit", "orange", PageContext.REQUEST_SCOPE);
                pageContext.setAttribute("fruit", "banana", PageContext.SESSION_SCOPE);
                pageContext.setAttribute("fruit", "watermelon", PageContext.APPLICATION_SCOPE);
                pageContext.setAttribute("name", "张三");

   %>
   page=【】<br>
   request=【】<br>
   session=【】<br>
   application=【】<br>
   name=【】<br>

    <hr>
   <h3>3.代表了请求参数的map集合的2个对象 param paramValues</h3>
  <%--  name=<%=request.getParameter("name") %><br>
   like=<%=request.getParameterValues("like")[0] %><br>
   like=<%=request.getParameterValues("like")[1] %><br>
   like=<%=request.getParameterValues("like")[2] %><br> --%>
   name=【】<br>
   like=【】<br>
   like=【】<br>
   like=【】<br>
    <hr>
   <h3>4.代表了请求头数据的map集合的2个对象 header headerValues</h3>
   host=<%=request.getHeader("host") %><br>
   cookie=【】<br>

    <hr>
   <h3>5.代表了所有Cookie的map集合</h3>
   <%
        Cookie[] cs=request.getCookies();
        Cookie c1=cs[0];
        String name=c1.getName();
        String value=c1.getValue();
   %>
   cookie=【】~~~【】
       <hr>
   <h3>6.代表了web.xml中配置的初始化参数</h3>
   name=【】<br>
   job=【】<br>
   <br><br><br><br><br>
  </body>
</html>
