<%@ page import="java.util.*" pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE HTML>
<html>
  <head>
  </head>
  <body>
  	<%-- pageContext域(page域) --%>
	<%
		pageContext.setAttribute("name", "zs");
	 %>
	 <%= pageContext.getAttribute("name") %>
	 <%--pageContext作为入口操作四大作用域 --%>
	 <%
	 	//application.setAttribute("country", "CHINA");
	 	//session.setAttribute("country", "US");
	 	//request.setAttribute("country", "UK");
	 	//pageContext.setAttribute("country", "JAPAN");
	  %>
	  <%= pageContext.getAttribute("country", PageContext.SESSION_SCOPE) %>
	  <%--findAttribute自动搜寻属性 --%>
	  <%= pageContext.findAttribute("country") %>
	  
	  <%--便捷的请求转发 --%>
	  <%-- request.getRequestDispatcher("/index.jsp").forward(request, response); --%>
	  <% pageContext.forward("/index.jsp");%>
  </body>
</html>
