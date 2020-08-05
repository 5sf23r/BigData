<%@page import="cn.tedu.domain.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>JSTL标签库</title>
	</head>
	<body>
		<hr><h1>c:catch 捕获异常</h1>
		<c:catch var="e">
		<%
			String str = null;
			str.toUpperCase();
		 %>
		 </c:catch>
		 ${e}

		<hr><h1>c:if 实现判断</h1>
		<%
			pageContext.setAttribute("num", 18);
		 %>
		<c:if test="${num > 20}" scope="page" var="flag">
			yes~
		</c:if>
		<c:if test="${num <= 20}">
			no~
		</c:if>
		${flag}

		<hr><h1>c:choose 实现多重判断</h1>
		<%
			pageContext.setAttribute("num", 18);
		 %>
		<c:choose>
			<c:when test="${num<10 }">小于10</c:when>
			<c:when test="${num<100 }">大于10小于100</c:when>
			<c:when test="${num<1000 }">大于100小于1000</c:when>
			<c:otherwise>大于1000</c:otherwise>
		</c:choose>

		<hr><h1>c:foreach 实现循环遍历</h1>
		<%
			List<String> list = new ArrayList<String>();
			list.add("aa");
			list.add("bb");
			list.add("cc");
			list.add("dd");
			list.add("ee");
			pageContext.setAttribute("list", list);
		 %>
		 <c:forEach items="${list }" var="x">
		 	${x } 
		 </c:forEach>
		 <c:forEach begin="0" end="100" step="2" var="i">
		 	${i } 
		 </c:forEach>
		 
		<hr><h1>c:foreach案例：遍历10到100的偶数，如果数字所在的位置是3的倍数，显示成红色</h1>
		<c:forEach begin="10" end="100" step="2" var="i" varStatus="stat">
			<c:if test="${stat.count % 3 == 0 }">
				<font color="red">${i }</font>
			</c:if>
			<c:if test="${stat.count % 3 != 0 }">
				<font color="blue">${i }</font>
			</c:if>
		</c:forEach>
		
		<hr><h1>c:fortoken </h1>
		<c:forTokens items="www.tedu.cn" delims="." var="str">
			${str}<br>
		</c:forTokens>		
	</body>
</html>
