<%@page import="cn.tedu.domain.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>JSTL标签库</title>
	</head>
	<body>
		<hr><h1>c:set 设置/修改域属性 </h1>
		<c:set scope="request" var="name" value="zs"></c:set>
		${name}
		<c:set scope="request" var="name" value="ls"></c:set>
		${name}
		
		<hr><h1>c:set 设置/修改域中Map属性 </h1>
		<%
			Map<String,String> map = new HashMap<String,String>();
			pageContext.setAttribute("map", map);
		 %>
		<c:set target="${map }" property="addr" value="bj"></c:set>
		${map.addr }
		<c:set target="${map }" property="addr" value="sh"></c:set>
		${map.addr }
		
		<hr><h1>c:set 设置/修改域中javabean属性 </h1>
		<%
			Person p = new Person("ww",19,"gz");
			pageContext.setAttribute("p", p);
		 %>
		<c:set target="${p }" property="age" value="20"></c:set>
		${p.age}	
		
		<hr><h1>c:remove 删除所有域或指定域中的属性 </h1>
		<c:set var="namex" value="zl1" scope="page"></c:set>
		<c:set var="namex" value="zl2" scope="request"></c:set>
		<c:set var="namex" value="zl2" scope="session"></c:set>
		<c:set var="namex" value="zl2" scope="application"></c:set>
		<c:set var="agex" value="18" scope="page"></c:set>
		${pageScope.namex }
		${requestScope.namex }
		${sessionScope.namex }
		${applicationScope.namex }
		${agex }
		<c:remove var="namex" scope="page"/>
		${pageScope.namex }
		${requestScope.namex }
		${sessionScope.namex }
		${applicationScope.namex }
		${agex }
		<c:remove var="namex"/>
		${pageScope.namex }
		${requestScope.namex }
		${sessionScope.namex }
		${applicationScope.namex }
		${agex }
	</body>
</html>
