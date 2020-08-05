<%@page import="cn.tedu.domain.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>EL执行运算</title>
	</head>
	<body>
		<hr><h1>EL执行运算 - 算术运算</h1>
		${3 + 2}
		${3 - 2}
		${3 * 2}
		${3 / 2}
		${3 % 2 }
		${"3" + 2 }
		${"3" + "2" }
		<%-- ${"a" + 2 } --%>
		<hr><h1>EL执行运算 - 关系运算</h1>
		${3 == 2 }
		${3 > 2 }
		${3 >= 2 }
		${3 < 2 }
		${3 <= 2 }
		${3 != 2 }
		<hr><h1>EL执行运算 - 逻辑运算</h1>
		${true and false }
		${true && false }
		${true or false }
		${true || false }
		${not (3>2) }
		${! (3>2) }
		<hr><h1>EL执行运算 - empty运算</h1>
		<h1>Empty运算规则：如果对象为null 字符串为空 集合数组没有任何元素 empty操作都会返回true，否则false</h1>
		<%
			String country = "China";
			pageContext.setAttribute("country", country);
			String province = "";
			pageContext.setAttribute("province",province);
			List<String> listx = new ArrayList<String>();
			pageContext.setAttribute("listx",listx);
		 %>
		${empty country}
		${empty province}
		${empty listx}
		<hr><h1>EL执行运算 - 三元表达式</h1>
		<%
			Map<String,String> map = new HashMap<String,String>();
			map.put("name", "杨过");
			map.put("武功", "黯然销魂掌");
			map.put("wife", "姑姑");
			map.put("宠物", "雕");
			pageContext.setAttribute("map", map);
		 %>
		 ${empty map.wife ? "小龙女" : map.wife }
	</body>
</html>
