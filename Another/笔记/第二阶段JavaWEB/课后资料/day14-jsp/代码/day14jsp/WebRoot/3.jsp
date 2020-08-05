<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
  isErrorPage="true"

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
      <h3>功能三：作为三大作用域的入口</h3>
      <%
      	pageContext.setAttribute("country", "China", PageContext.APPLICATION_SCOPE);
      	pageContext.setAttribute("country", "US", PageContext.SESSION_SCOPE);
      	pageContext.setAttribute("country","UK",PageContext.REQUEST_SCOPE);
      	pageContext.setAttribute("country","Japan",PageContext.PAGE_SCOPE);
      	
       %>
       <h4>获取指定域当中的数据</h4>
       page：<%=pageContext.getAttribute("country", PageContext.PAGE_SCOPE) %>
       request：<%=pageContext.getAttribute("country",PageContext.REQUEST_SCOPE) %>
       session：<%=pageContext.getAttribute("country",PageContext.SESSION_SCOPE) %>
       application:<%=pageContext.getAttribute("country",PageContext.APPLICATION_SCOPE) %>
       
       	<h4>直接书写pageContext获取的是pageContext域</h4>
       <%=pageContext.getAttribute("country") %>
       <h4>删除指定域中属性</h4>
       <%
       		pageContext.removeAttribute("country", PageContext.PAGE_SCOPE);
        %>
                    删除之后的page域：<%=pageContext.getAttribute("country") %>
      	<h4>便捷的请求转发</h4>
      	<%
      		//pageContext.forward("/2.jsp");
      	 %>
      
      
      
      
      
      
      
      
  </body>
</html>
