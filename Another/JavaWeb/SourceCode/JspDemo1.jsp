<%@ page language="java" import="java.util.*,java.net.URLDecoder" pageEncoding="UTF-8" session="true" errorPage="/errorPage/myErrorPage.jsp"  %>
<%@ page import="java.io.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>

  <body>

    <h1>JSP的语法</h1>
    <h3>1.JSP的模版元素</h3>
    1.1 JSP中所有的HTML的内容称为JSP的模版元素
    <br> 1.2 所有的模版元素在翻译后的Servlet中作为字符串由out.write()来输出
    <hr>
    <%
      int i = 20;
      %>
    <h3>2.JSP的表达式</h3>
    常量：【】<br>
    变量：【】<br>
    逻辑运算：【】<br>
    关系运算：【】<br>
    表达式的内容会原样作为参数放入out.print()方法中
    <br> 表达式的结果必须是一个值
    <br>
    <hr>
    <h3>3.JSP的脚本片段</h3>
    【循环输出5遍 hello jsp】
    <hr>
    <h3>4.JSP的声明</h3>
    【全局变量】
    【局部变量】
    a=【累加】<br>
    b=【累加】<br>
    【全局方法】
    【静态方法】
    【定义常量】

    <hr>
    <h3>5.JSP的注释</h3>
    <%-- JSP注释，给JSP开发者看的，不会出现在翻译后的java文件中，也不会出现在浏览器上 --%>
    <% //java注释，给Java开发者看的，会出现在翻译后的java文件中，不会出现在浏览器上 %>
    <!-- HTML注释，调试HTML内容时看的，会出现在翻译后的java文件中，也会出现在浏览器上 -->

    在JSP中尽量使用JSP注释，不要使用html注释，因为HTML注释后的java脚本还可能被执行
    <% int d=20; %>
    <%-- <% d=50; %> --%>
    d=<%=d %>

    <h3>6.JSP的page指令</h3>
    sessionId=<%=session.getId()%>【session】
    <%=10/0 %>【errorPage】
    <br>
    <br>
    <br>
    <br>
    <br>
  </body>
</html>
