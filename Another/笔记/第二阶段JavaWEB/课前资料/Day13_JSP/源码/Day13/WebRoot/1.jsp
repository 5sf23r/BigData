<%@ page import="java.util.*" pageEncoding="ISO-8859-1" 
	import="java.io.FileInputStream" session="false" errorPage="error.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
  </head>
  <body>
  	<%! int i = 0; %>
  	<%!
		public void mx(){}
		static{}
		class Personx{}
		{
		
		}  	
  	 %>
  	 <%
  	 	FileInputStream fs = null;
  	 	HttpServletRequest req = null;
  	 %>
  	<%
  		for(int i =0;i<5;i++){
  	%>
  		<font color='red'>this is first jsp!</font><br>
  		
  	<% } %>
  	<%= new Date().toLocaleString() %>
  	
  	<!-- abc --> html注释被当做模板元素输出到了浏览器，但浏览器不予展示
  	<% //ghi %> java注释被当做脚本片段翻译到了Servlet中，但代码被注释不能执行
  	<%-- def --%> jsp注释在翻译成Servlet过程中被抛弃，不会出现在翻译出来的Servlet中
  	
  	<% int i = 1/0; %>
  	
  </body>
</html>
