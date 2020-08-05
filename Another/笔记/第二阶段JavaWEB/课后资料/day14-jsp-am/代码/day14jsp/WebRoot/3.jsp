<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
session="false"  isErrorPage="true"

%>

<!DOCTYPE HTML >
<html>
  <head>
   	<title>pageContext详解</title>
  </head>
  
  <body>
   <h3>功能一：作为其他八大隐式对象的入口</h3>
   	<%
   		pageContext.getPage();
   		
   	 %>
   <h3>功能二：作为域对象使用</h3>
   <%
   		pageContext.setAttribute("name", "lishuai");
   
    %>
    <br/>
    pageContext域中取出数据：
    <%=
    	pageContext.getAttribute("name")
     %>
  </body>
</html>
