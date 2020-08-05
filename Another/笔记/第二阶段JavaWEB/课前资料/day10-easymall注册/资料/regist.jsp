<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>欢迎注册EasyMall</title>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="css/regist.css"/>
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			//注册表单校验
			var formObj = {
				checkForm: function(){
					var flag = true;
					//用户名
					flag = this.checkNull("username", "用户名不能为空") && flag;
					flag = this.checkNull("password", "密码不能为空") && flag;
					flag = this.checkNull("password2", "确认密码不能为空") && flag;
					flag = this.checkNull("nickname", "昵称不能为空") && flag;
					flag = this.checkNull("email", "邮箱不能为空") && flag;
					flag = this.checkNull("valistr", "验证码不能为空") && flag;
					flag = this.checkPassword("password", "两次密码不一致") && flag;
					flag = this.checkEmail("email", "邮箱格式不正确") && flag;
					
					return flag;
				},
				checkEmail: function(name, msg){
					var email = $("input[name="+name+"]").val();
					
					this.setMsg(name, "");
					
					this.checkNull(name, "邮箱不能为空");
					
					if($.trim(email) != ""){
						var reg = /^\w+@\w+(\.\w+)+$/;
						if(!reg.test(email)){
							this.setMsg(name, msg);
							return false
						}
					}
					return true;
				},
				checkPassword: function(name, msg){
					var psw1 = $("input[name="+name+"]").val();
					var psw2 = $("input[name="+name+"2]").val();
					
					this.setMsg(name+"2", "");
					
					this.checkNull(name+"2", "确认密码不能为空");
					
					if($.trim(psw1) != "" && $.trim(psw2) != ""){
						if(psw1 != psw2){
							this.setMsg(name+"2", msg);
							return false;
						}
					}
					return true;
				},
				checkNull: function(name, msg){
					var value = $("input[name="+name+"]").val();
					this.setMsg(name, "");
					if($.trim(value) == ""){
						this.setMsg(name, msg);
						return false;
					}
					return true;
				},
				setMsg:function(name, msg){
					$("#"+name+"_msg").html("<font style='color: red'>"+msg+"</font>");
				}
			
			}
		
		</script>
	</head>
	<body>
		<form onsubmit="return formObj.checkForm()" action="<%= request.getContextPath() %>/RegistServlet" method="POST"
			>
			<h1>欢迎注册EasyMall</h1>
			<table>
				<tr>
					<td class="tds" colspan="2" style="color:red; text-align: center;">
						<%= request.getAttribute("msg")==null ? "" : request.getAttribute("msg") %>
					</td>
				</tr>
				<tr>
					<td class="tds">用户名：</td>
					<td>
						<input type="text" name="username"
							onblur="formObj.checkNull('username', '用户名不能为空')"
						/>
						<span id="username_msg"></span>
					</td>
				</tr>
				<tr>
					<td class="tds">密码：</td>
					<td>
						<input type="password" name="password"
							onblur="formObj.checkNull('password', '密码不能为空')"
						/>
						<span id="password_msg"></span>
					</td>
				</tr>
				<tr>
					<td class="tds">确认密码：</td>
					<td>
						<input type="password" name="password2"
							onblur="formObj.checkPassword('password', '两次密码不一致')"
						/>
						<span id="password2_msg"></span>
					</td>
				</tr>
				<tr>
					<td class="tds">昵称：</td>
					<td>
						<input type="text" name="nickname"
							onblur="formObj.checkNull('nickname', '昵称不能为空')"
						/>
						<span id="nickname_msg"></span>
					</td>
				</tr>
				<tr>
					<td class="tds">邮箱：</td>
					<td>
						<input type="text" name="email"
							onblur="formObj.checkEmail('email', '邮箱格式不正确')"
						/>
						<span id="email_msg"></span>
					</td>
				</tr>
				<tr>
					<td class="tds">验证码：</td>
					<td>
						<input type="text" name="valistr"
							onblur="formObj.checkNull('valistr', '验证码不能为空')"
						/>
						<img src="img/regist/yzm.jpg" width="" height="" alt="" />
						<span id="valistr_msg"></span>
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
