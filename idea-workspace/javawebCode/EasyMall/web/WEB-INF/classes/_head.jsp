<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<link rel="stylesheet" href="css/head.css"/>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />

<div id="common_head">
	<div id="line1">
		<div id="content">
			<%--
				如果session的username为空，显示【登录】
				如果session的username不为空，显示【欢迎：  回来】
			--%>
			<%
				String username = (String) request.getSession().getAttribute("username");
				if (username == null || "".equals(username)) {
			%>
					<a href="#">登录</a>&nbsp;&nbsp;|
			<%
				} else {
			%>
					<a href="#">欢迎：<%=username%> 回来</a>&nbsp;&nbsp;
			<%
				}
			%>
			&nbsp;&nbsp;
			<!-- 由于当前项目是虚拟主机的默认web应用，因此项目映射的URL应该是“” -->
			<!-- <a href="/EasyMall/regist.jsp">注册</a> -->
			<a href="/regist.jsp">注册</a>

		</div>
	</div>
	<div id="line2">
		<img id="logo" src="img/head/logo.jpg"/>
		<input type="text" name=""/>
		<input type="button" value="搜 索"/>
		<span id="goto">
			<a id="goto_order" href="#">我的订单</a>
			<a id="goto_cart" href="#">我的购物车</a>
		</span>
		<img id="erwm" src="img/head/qr.jpg"/>
	</div>
	<div id="line3">
		<div id="content">
			<ul>
				<li><a href="#">首页</a></li>
				<li><a href="#">全部商品</a></li>
				<li><a href="#">手机数码</a></li>
				<li><a href="#">电脑平板</a></li>
				<li><a href="#">家用电器</a></li>
				<li><a href="#">汽车用品</a></li>
				<li><a href="#">食品饮料</a></li>
				<li><a href="#">图书杂志</a></li>
				<li><a href="#">服装服饰</a></li>
				<li><a href="#">理财产品</a></li>
			</ul>
		</div>
	</div>
</div>
