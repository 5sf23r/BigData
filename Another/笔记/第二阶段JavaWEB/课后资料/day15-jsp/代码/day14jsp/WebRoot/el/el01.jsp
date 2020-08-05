<%@page import="cn.tedu.domain.Person"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>el表达式</title>
</head>
<body>
	<h3>el表达式功能一：获取数据</h3>
	<h4>获取常量</h4>
	脚本片段书写：<br/>
	<%=123 %>  
	<%="abc" %>  
	<%=true %>  
	<%=1.1 %>  
	<br/>el表达式书写：<br/>
	${123} 
	${"abc" }
	${true }
	${1.1 }
	<h4>自动搜寻域</h4>
	<%
		application.setAttribute("name", "兰刚");
		session.setAttribute("name","朴乾");
		request.setAttribute("name","李帅");
		//pageContext.setAttribute("name","张三");
	
	 %>
	 <%=pageContext.findAttribute("name") %>
	 
	 ${name }
	<h4>获取指定域中的属性</h4>
	<%
		application.setAttribute("job", "IT");
		session.setAttribute("job", "teacher");
		request.setAttribute("job", "doctor");
		pageContext.setAttribute("job", "work");
	 %>
	 <%=pageContext.getAttribute("job", PageContext.APPLICATION_SCOPE) %>
	el表达式获取指定域的属性：
	${applicationScope.job}
	${sessionScope.job }
	${requestScope.job }
	${pageScope.job }

	<h4>获取变量</h4>
	获取web应用的虚拟路径：<br>
	<%=request.getContextPath() %>
	<br>
	${pageContext.request.contextPath}	
	
	<h4>el表达式数组中获取数据</h4>
	<%
		String[] names = {"殷天正","黛琦丝","谢逊","韦一笑"};
		pageContext.setAttribute("names", names);
	 %>
	${names[1]}
	<h4>获取集合中的元素</h4>
	<%
		List<String> list = new ArrayList<String>();
		list.add("大数据");
		list.add("小数据");
		list.add("中数据");
		pageContext.setAttribute("list", list);
	 %>
	 ${list[0]}	
	<h4>获取Map中的元素</h4>
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "李帅");
		map.put("武功","黯然销魂掌");
		map.put("wife","姑姑");
		map.put("wife.one","小龙女");
		pageContext.setAttribute("map", map);
		/* 书写一个字符串数据添加到域中，即可获取变量名中包含的数据 */
		pageContext.setAttribute("wife", "wife");
		
	 %>
	 ${map["name"] }
	 ${map.武功 }
	 ${map[wife] }
	 ${map["wife.one"] }
	
	<h3>获取javabean中的元素</h3>
	<%
		Person p = new Person();
		p.setName("lishuai");
		p.setAge(18);
		p.setAddr("bj");
		pageContext.setAttribute("p", p);
	
	 %>
	 ${p.name }
	 ${p.age }
	 ${p.addr }
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	
	
	
	
	
	
</body>
</html>