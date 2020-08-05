<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css"/>
		<title>EasyMall欢迎您登陆</title>
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" >
			//从cookie中读取数据remname
			window.onload = function(){
				$("#username").val(decodeURI('${cookie.remname.value}'));
				
			}
		</script>
	</head>
	<body>
		<h1>欢迎登陆EasyMall</h1>
		<form action="${pageContext.request.contextPath }/LoginServlet" method="POST">
			<table>
			<%-- <%
				Cookie remnameC = null;
				Cookie[] cs = request.getCookies();
				if(cs != null){
					for(Cookie c:cs){
						if("remname".equals(c.getName())){
							remnameC = c;
						}
					}
				}
				String username = "";
				if(remnameC !=null){
					username = URLDecoder.decode(remnameC.getValue(), "utf-8");
				}
			
			 %> --%>
				<tr>
					<td class="tds" colspan=2 style="color:red;text-align:center">
						<%-- <%=request.getAttribute("msg")==null?"": request.getAttribute("msg")%> --%>
						${requestScope.msg }
					</td>
				</tr>
				<tr>
					<td class="tdx">用户名：</td>
					<td><input id="username" type="text" name="username" /></td>
				</tr>
				<tr>
					<td class="tdx">密&nbsp;&nbsp; 码：</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="remname" value="true" 
						
						<c:if test="${not empty cookie.remname }">
							checked="checked"
						</c:if>
						
						
						/>记住用户名
						<input type="checkbox" name="autologin" value="true"/>30天内自动登陆
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登 陆"/>
					</td>
				</tr>
			</table>
		</form>		
	</body>
</html>
