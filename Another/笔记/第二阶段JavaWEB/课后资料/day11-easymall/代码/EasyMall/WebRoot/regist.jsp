<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>欢迎注册EasyMall</title>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/regist.css"/>
		<!-- 引入jQuery函数库 -->
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.2.js">	
		</script>
		<script type="text/javascript">
			/* 前台校验操作 */
			var formObj = {
				checkForm : function(){
					var canSub = true;
					
					canSub = this.checkNull("username","用户名称不能为空") && canSub;
					canSub = this.checkNull("password","密码不能为空") && canSub ;
					canSub = this.checkNull("password2","确认密码不能为空")&& canSub;
					canSub = this.checkNull("email","邮箱不能为空")&& canSub;
					canSub = this.checkNull("nickname","昵称不能为空")&& canSub;
					canSub = this.checkNull("valistr","验证码不能为空")&& canSub;
					canSub = this.checkEmail()&& canSub;
					canSub = this.checkPassword()&& canSub;
					
					return canSub;
				},
				checkPassword : function(){
					//密码一致性校验
					var password = $("input[name='password']").val();
					var password2 = $("input[name='password2']").val();
					if(password!=""&&password2!=""&&password != password2){
						this.setMsg("password2", "两次密码不一致");
						return false;
					}
					return true;
				},
				checkEmail : function(){
					//邮箱格式校验
					var reg = /\w+@\w+(\.\w+)+/; 
					var email = $("input[name='email']").val();
					
					if(email!="" && !reg.test(email)){
						this.setMsg("email", "邮箱格式不正确");
						return false;
					}
					return true;
				},
				//非空校验
				checkNull : function(name,msg){
					var tag = $("input[name='"+name+"']").val();
					//清空操作
					/* $("input[name='"+name+"']").nextAll("span").text(""); */
					this.setMsg(name, "");
					if($.trim(tag) == ""){
						/* $("input[name='"+name+"']").nextAll("span").text(msg); */
						this.setMsg(name, msg);
						return false;
					}
					return true;
				},
				setMsg : function(name,msg){
					//设置信息
					$("input[name='"+name+"']").nextAll("span").text(msg).css("color","red");
				}
				
			};
			
			//文档就绪事件
			$(function(){
				//鼠标离开焦点事件
				$("input[name='username']").blur(function(){
					formObj.checkNull("username", "用户名不能为空");
				});
				$("input[name='password']").blur(function(){
					formObj.checkNull("password", "密码不能为空");
				});
				$("input[name='password2']").blur(function(){
					formObj.checkNull("password2", "确认密码不能为空");
					formObj.checkPassword();
				});
				$("input[name='email']").blur(function(){
					formObj.checkNull("email", "邮箱不能为空");
					formObj.checkEmail();
				});
				$("input[name='nickname']").blur(function(){
					formObj.checkNull("nickname", "昵称不能为空");
				});
				$("input[name='valistr']").blur(function(){
					formObj.checkNull("valistr", "验证码不能为空");
				});
			});
		</script>
	</head>
	<body>
		<form action="<%=request.getContextPath() %>/RegistServlet" method="POST" onsubmit="return formObj.checkForm()">
			<h1>欢迎注册EasyMall</h1>
			<table>
				<tr>
					<td class="tds" colspan=2 style="color:red;text-align:center">
						<%=request.getAttribute("msg")==null?"": request.getAttribute("msg")%>
					</td>
					
				</tr>
				<tr>
					<td class="tds">用户名：</td>
					<td>
						<input type="text" name="username" value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>"/>
						<span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">密码：</td>
					<td>
						<input type="password" name="password"/><span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">确认密码：</td>
					<td>
						<input type="password" name="password2"/><span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">昵称：</td>
					<td>
						<input type="text" name="nickname" value="<%=request.getParameter("nickname")==null?"":request.getParameter("nickname")%>"/>
						<span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">邮箱：</td>
					<td>
						<input type="text" name="email" value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>"/>
						<span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">验证码：</td>
					<td>
						<input type="text" name="valistr"/>
						<img src="<%=request.getContextPath() %>/img/regist/yzm.jpg" width="" height="" alt="" />
						<span ></span>
					</td>
				</tr>
				<tr>
					<td class="sub_td" colspan="2" class="tds">
						<input type="submit" value="注册用户"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
