<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.io.FileInputStream"  session="false"
errorPage="error.jsp"
isErrorPage="true"

%>
<%@page import="java.io.FileOutputStream" %>

<!DOCTYPE HTML >
<html>
  <head>
   
  </head>
  
  <body>
   <h3>page指令</h3>
   <%
   	HttpServletRequest requests = null;
   	HttpServletResponse rep = null;
   	
   	FileInputStream in = null;
   FileOutputStream o = null;
    %>
    <% //int i=1/0; 
    	//String str = null;
    	//str.toLowerCase();
    %>
  </body>
</html>
