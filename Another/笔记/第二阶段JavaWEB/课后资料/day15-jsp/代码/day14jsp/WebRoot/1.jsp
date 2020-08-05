<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
  <head>
   
  </head>
  
  <body>
    <div>aaaa</div>
    
    <h3>脚本表达式</h3>
    <%=request.getContextPath() %>
    <h3>脚本片段</h3>
  	<%
  		for(int i=0;i<5;i++){
  		%>
  		
  		<font color='red'>I am li shuai;</font>
  		
  		<%
  		}
  	
  	 %>
  	 <h3>JSP声明</h3>
  	 <%! int i =0; %>
  	 <%! public void m(){} %>
  	 <%!static{} %>
  	 <h3>JSP注释</h3>
  	 java注释：<%//abc %><br/>
  	 HTML注释：<!-- ghi --><br/>
  	 JSP注释：<%--def --%>
  </body>
</html>
