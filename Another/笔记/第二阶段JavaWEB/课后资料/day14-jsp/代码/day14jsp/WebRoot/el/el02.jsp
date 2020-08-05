
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>el表达式</title>
</head>
<body>
	<h3>el表达式功能二：运算</h3>
	<h4>算术运算</h4>
	${2+3 }
	${2-3 }
	${3/2 }
	${3%2 }
	<hr>
	${2+"3" }
	<hr>
	${"2"+"3" }
	在加法中如果有字符串类型的数据，尝试将这个数据转换成一个数值类型，如果能够转换则
	转换过后执行运算，如果不能转换则会报错。
	<%-- ${2+"a" } --%>
	<h4>关系运算</h4>
	${3>2 }
	${3<2 }
	${3>=2 }
	${3<=2 }
	${3!=2 }
	<h4>逻辑运算</h4>
	${true and false }
	${true or false }
	${not(true) }
	
	${true && false }
	${true || false }
	${!true }
	<h4>empty运算</h4>
	<%
		String a = null;
		String str = "aaaa";
		String[] arr = {"1"};
		ArrayList list = new ArrayList();
		list.add("abc");
		Map map = new HashMap();
		
		pageContext.setAttribute("a",a);
		pageContext.setAttribute("str",str);
		pageContext.setAttribute("arr",arr);
		pageContext.setAttribute("list",list);
		pageContext.setAttribute("map", map);
		
	 %>
	${empty a}
	${empty str}
	${empty arr}
	${empty list}
	${empty map}
	
	<h4>三元表达式</h4>
	<%
		Map<String,String> mapx = new HashMap<String,String>();
		mapx.put("a","aa");
		mapx.put("b","bb");
		mapx.put("c","cc");
		pageContext.setAttribute("mapx", mapx);
	
	 %>
	 ${empty mapx.b?"yes":"no" }
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