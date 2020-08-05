<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.io.FileInputStream"  session="false"
isErrorPage="true"
%>
<%@page import="java.io.FileOutputStream" %>

<!DOCTYPE HTML >
<html>
  <head>
   
  </head>
  
  <body>
   当前页面已经报错，检查代码书写内容。<%=exception.getMessage()%>
  </body>
</html>
