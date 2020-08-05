<%@ page language="java" import="java.util.*" pageEncoding="utf-8"	isErrorPage="true"
%>
<!DOCTYPE HTML>
<html>
  <head>
  </head>
  <body>
  	全局错误提示：500，您要访问的资源出错了~
  	<%= exception.getMessage() %>
  </body>
</html>
