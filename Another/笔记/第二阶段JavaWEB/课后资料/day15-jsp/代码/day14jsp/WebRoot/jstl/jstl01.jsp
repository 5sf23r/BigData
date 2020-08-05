<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import="cn.tedu.domain.Person"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java"   pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSTL</title>
</head>
<body>
    <h3>c:set</h3>
	<h4>c:set标签，设置或修改值</h4>
	<c:set var="a" value="bj" scope="request"></c:set>
	${a  }
	<c:set var="a" value="sh" scope="request"></c:set>
	${a }
	<h3>c:set设置或修改map中的值</h3>
	<%
		Map<String,String> map = new HashMap<String,String>();
		pageContext.setAttribute("map", map);
	 %>
	 <c:set target="${map }" property="addr" value="重庆"></c:set>
	${map }
	${map.addr}
	<c:set target="${map }" property="addr" value="宝安"></c:set>
	${map.addr }
	<h4>c:set设置或修改javabean中的属性</h4>
	<%
		Person p = new Person("李帅",18,"北京");
		pageContext.setAttribute("p",p);
	 %>
	 <c:set target="${p }" property="name" value="朴乾"></c:set>
	${p.name }
	${p.age }
	<!-- javabean中不存在的属性不能直接设置值 -->
	<%-- <c:set target="${p }" property="gender" value="男"></c:set>--%>
    <%-- ${p.gender }  --%>

    <h3>c:remove</h3>
    <h4>c:remove删除指定域中的域属性</h4>
    <c:set var="name" value="张三丰" scope="request"></c:set>
    ${name }
    <br>
	<c:remove var="name" scope="request"></c:remove>
	调用remove：${name }
	<h4>删除全部域中的域属性</h4>
	<%
		application.setAttribute("namex", "大一");
		session.setAttribute("namex", "大二");
		request.setAttribute("namex", "大三");
		pageContext.setAttribute("namex", "大四");
		
	 %>
	<%--  <c:remove var="namex"></c:remove> --%>
	 <c:remove var="namex" scope="page"></c:remove>
	 
	 ${applicationScope.namex }
	 ${sessionScope.namex }
	 ${requestScope.namex }
	 ${pageScope.namex }
	 <h3>c:if</h3>
	 <h4>c:if判断</h4>
	<c:set var="i" value="10" scope="request"></c:set>
	<c:if test="${i<=10 }" var="flag">
		no~~~
	</c:if>
	
	<c:if test="${i>10 }" var="f">
		yes
	</c:if>
	${flag }
	${f }
	<h3>c:catch</h3>
	<h4>c:catch捕获异常信息</h4>
	<c:catch var="e">
		<%
			String str = null;
			str.toUpperCase();
		 %>
	</c:catch>
	${e }
	<h3>c:choose</h3>
	<h4>c:choose实现多重判断</h4>
	<c:set var="b" value="18" scope="request"></c:set>
	<c:choose >
		<c:when test="${b<10 }" >小于10</c:when>
		<c:when test="${b<100 }">大于10小于100</c:when>
		<c:when test="${b<1000 }">大于100小于1000</c:when>
		<c:otherwise>大于1000</c:otherwise>
	</c:choose>
	<h4>c:forTokens</h4>
	<c:forTokens items="www.tedu.cn" delims="." var="stat">
		${stat }<br>
	</c:forTokens>
	<h3>c:forEach实现循环</h3>
	<h4>c:forEach循环数字</h4>
	<c:forEach begin="1" end="100" step="1" var="q">
		${q }
	</c:forEach>
	
	<h4>c:forEach遍历链表</h4>
	<%
		List<String> list = new LinkedList<String>();
	 	list.add("danny");
	 	list.add("jenny");
	 	list.add("liming");
	 	list.add("laowang");
	 	pageContext.setAttribute("list", list);
	 %>
	 <c:forEach items="${list }" var="h" varStatus="stat">
	 	${h }
	 	${stat.index }
	 </c:forEach>
	 <h4>varStatus属性演示</h4>
	 <c:forEach begin="10" end="100" step="1" var="o" varStatus="stat"> 
	 	${stat.index }
	 </c:forEach>
	 <br>
	问题：遍历一个10到100的全部偶数，如果当前总数的下标为3的倍数，则将这个数据变为红色。
	<br>
	 <c:forEach begin="10" end="100" step="2" var="r" varStatus="s">
	 	<c:if test="${s.count%3 == 0}">
	 		<font color="red">${r }</font>
	 	</c:if>
	 	<c:if test="${s.count%3 != 0 }">
	 		<font color="blue">${r }</font>
	 	</c:if>
	 </c:forEach>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>