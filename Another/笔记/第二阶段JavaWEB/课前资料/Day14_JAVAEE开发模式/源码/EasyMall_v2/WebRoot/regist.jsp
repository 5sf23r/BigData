<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>欢迎注册EasyMall</title>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/regist.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			var formObject = {
				"checkForm" : function(){
				    var canSub = true;
					//非空校验
					canSub = this.checkNull("username","用户名不能为空") && canSub;
					canSub = this.checkNull("password","密码不能为空") && canSub;
					canSub = this.checkNull("password2","确认密码不能为空") && canSub;
					canSub = this.checkNull("nickname","昵称不能为空") && canSub;
					canSub = this.checkNull("email","邮箱不能为空") && canSub;
					canSub = this.checkNull("valistr","验证码不能为空") && canSub; 
					//密码一致性校验
					canSub = this.checkPassword("password","两次密码不一致") && canSub;
					//邮箱格式校验
					canSub = this.checkEmail("email","邮箱格式不正确") && canSub;
					//
					return canSub;
				},
				"checkPassword" : function(name,msg){
					var password = $("input[name='"+name+"']").val();
					var password2 = $("input[name='"+name+"2']").val();
					if($.trim(password) != "" && $.trim(password2) !=""
					&& $.trim(password) != $.trim(password2)){
						$("input[name='"+name+"2']").next().text(msg).css("color","red");
						return false;
					}
					return true;
				},
				"checkEmail" :function(name,msg){
					//直接获取邮箱文本框的内容
					var email = $("input[name='email']").val();
					//设置邮箱正则
					var reg = /^\w+@\w+(\.\w+)+$/;
					if($.trim(email) != "" && !reg.test(email)){
						//$("input[name='"+name+"']").next().text(msg).css("color","red");
						this.setMsg(name,msg);
						return false;
					}
					return true;
				},
				"checkNull" : function(name,msg){//非空校验
					var $inp = $("input[name="+name+"]");
					var tag = $inp.val();
					//清空操作
					this.setMsg(name, "");
					if($.trim(tag) == ""){
					//利用消息提示的方法提示信息。
						//$inp.nextAll("span").text(msg).css("color","red");
						this.setMsg(name,msg);
						//如果input框内容为空，则返回false
						return false;
					}
					//不为空则返回true
					return true;
				},
				"setMsg" : function(name,msg){
					var $inp = $("input[name="+name+"]");
					$inp.nextAll("span").text(msg).css("color","red");
				}
			};
			$(function(){//文档就绪事件
				//鼠标离焦事件
				//非空校验、密码一致性校验、邮箱格式校验
				$("input[name='username']").blur(function(){
					formObject.checkNull("username", "用不名不能为空");
				});
				$("input[name='password']").blur(function(){
					formObject.checkNull("password", "密码不能为空");
				});
				$("input[name='password2']").blur(function(){
					formObject.checkNull("password2", "确认密码不能为空");
					//在两次密码一致性的校验中，判断语句中已经将两个密码框为空的状态排除在外，所以不会出现错误提示的情况。
					formObject.checkPassword("password", "两次密码不一致");
				});
				$("input[name='nickname']").blur(function(){
					formObject.checkNull("nickname", "昵称不能为空");
				});
				$("input[name='email']").blur(function(){
					formObject.checkNull("email", "邮箱不能为空");
					formObject.checkEmail("email", "邮箱格式不正确");
				});
				$("input[name='valistr']").blur(function(){
					formObject.checkNull("valistr", "验证码不能为空");
				});
				//单击图片更换验证码
				$("#img1").click(function(){
					var date = new Date();
					var timestamp = date.toLocaleString();
					$(this).attr("src","${pageContext.request.contextPath}/ValistrServlet?time="+timestamp);
				});
				//ajax校验用户名是否存在
				$("input[name='username']").blur(function(){
					//检验用户名是否为空,如果为空则无需发生ajax校验。
					var flag = formObject.checkNull("username", "用户名不能为空");
					//flag如果为false则为空，打断代码，如果为true,则不为空，不打断代码。
					if(!flag){
						return;
					}
					//ajax校验操作查询姓名是否重复。
					var username = $(this).val();
					//load方式的ajax会将返回的结果数据保存在选择器所选择的对象当中。
					$("#username_msg").load("${pageContext.request.contextPath}/AjaxCheckUsernameServlet",{"username":username});
					//result对象是服务器返回的结果数据。这个结果数据可以是text/xml/json任意一个。
					//$.post("${pageContext.request.contextPath}/AjaxCheckUsernameServlet",{"username":username},function(result){
					//	alert(result);
					//});
				});
			});
		</script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/RegistServlet" method="POST" onsubmit="return formObject.checkForm()">
			<h1>欢迎注册EasyMall</h1>
			<table>
				<tr>
					<td class="tds" colspan=2 style="text-align:center;color:red;">${msg}</td>
				</tr>
				<tr>
					<td class="tds">用户名：</td>
					<td>
						<input type="text" name="username" value="${param.username }"/>
						<span id="username_msg"></span>
					</td>
				</tr>
				<tr>
					<td class="tds">密码：</td>
					<td>
						<input type="password" name="password"/>
						<span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">确认密码：</td>
					<td>
						<input type="password" name="password2"/>
						<span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">昵称：</td>
					<td>
						<input type="text" name="nickname" value="${param.nickname }"/>
						<span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">邮箱：</td>
					<td>
						<input type="text" name="email" value="${param.email }"/>
						<span ></span>
					</td>
				</tr>
				<tr>
					<td class="tds">验证码：</td>
					<td>
						<input type="text" name="valistr"/>
						<img id="img1" src="${pageContext.request.contextPath}/ValistrServlet"  width="" height="" alt="" />
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
