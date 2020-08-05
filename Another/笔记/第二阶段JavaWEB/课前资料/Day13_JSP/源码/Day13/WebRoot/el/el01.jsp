<%@page import="cn.tedu.domain.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>EL获取数据</title>
	</head>
	<body>
		<hr><h1>EL获取常量</h1>
		<%= 123 %>
		${123 }
		<%= 123.321 %>
		${123.321 }
		<%= "abc" %>
		${"abc" }
		<%= true %>
		${true }
		<%= false %>
		${false }
		<hr><h1>EL获取变量</h1>
		<% 
			application.setAttribute("name", "朴乾");
			session.setAttribute("name", "鑫三胖");
			request.setAttribute("name", "曹二胖");
			pageContext.setAttribute("name", "李一瘦");
		 %>
		 <%=pageContext.findAttribute("name") %>
		${name}
		<hr><h1>EL获取指定域中的变量</h1>
		${pageScope.name }
		${requestScope.name }
		${sessionScope.name }
		${applicationScope.name }
		<hr><h1>EL获取数组中的变量</h1>
		<% 
			String names [] = {"张三丰","张无忌","张翠山","谷丰硕"};
			pageContext.setAttribute("names", names);
		 %>
		 ${names[3] }
		<hr><h1>EL获取集合中的数据</h1>
		<%
			List<String> list = new ArrayList<String>();
			list.add("周芷若");
			list.add("赵敏");
			list.add("殷素素");
			list.add("小昭");
			list.add("灭绝师太");
			pageContext.setAttribute("list", list);
		 %>
		 ${list[3] }
		<hr><h1>EL获取Map中的数据</h1>
		<%
			Map<String,String> map = new HashMap<String,String>();
			map.put("name","韦小宝");
			map.put("job","爵爷");
			map.put("master","陈近南");
			map.put("gender","男");
			map.put("wife.first","双儿");
			pageContext.setAttribute("map", map);
			pageContext.setAttribute("job", "master");
		 %>
		 ${map["master"] }
		 ${map[job] }
		 ${map.gender }
		 ${map.name }
		 ${map["wife.first"] }
		 ${map.wife.first }
		<hr><h1>EL获取JavaBean中的属性</h1>
	 	<%
	 		Person p = new Person("zs",19,"bj");
	 		pageContext.setAttribute("p", p);
	 	 %>
 	 	${p.namex }
 	 	${p.age }
 	 	${p.addr }
 	 	${p["age"] }
	</body>
</html>
