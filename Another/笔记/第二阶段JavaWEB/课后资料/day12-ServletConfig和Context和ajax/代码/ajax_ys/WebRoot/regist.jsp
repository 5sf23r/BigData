<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>欢迎注册EasyMall</title>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="css/regist.css"/>
		<script type="text/javascript" src="js/ajax.js"></script>
		<script type="text/javascript">
			function checkNull(name, msg){
				var value = document.getElementsByName(name)[0].value;
				setMsg(name,"");
				if(value == ""){
					setMsg(name,msg);
					return false;
				}
				return true;
			}
			function setMsg(name, msg){
				document.getElementById(name+"_msg").innerHTML = "<font style='color:red;font-size: 14px;'>"+msg+"</font>";
			}
			
			
			var i = 0;

			function ajaxCheckUsername(thisobj){
				//检查用户名是否为空
				if(!checkNull("username", "用户名不能为空")){
					return;
				}
				
				//利用ajax实现用户名是否存在的校验
				var username = thisobj.value;
				
				//1.获取XMLHttpRequest对象
				var xmlHttp = ajaxFunction();
				
				//2.建立连接
				/*
				 * post: 请求方式
				 * url: 请求资源的路径
				 * async: 是否异步传输
				 */
				xmlHttp.open("POST", "${ pageContext.request.contextPath }/servlet/AjaxTestServlet", true);
				
				//3.发送请求
				//通知服务器发送的数据是请求参数
				xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xmlHttp.send("i="+(++i));
				
				//4.注册监听
				xmlHttp.onreadystatechange = function(){
					//时刻监听服务器处理请求的过程(状态), 但是我们只关心为4的状态
					if(xmlHttp.readyState == 4){
						//如果请求处理成功了才获取响应结果
						if(xmlHttp.status == 200){
							//获取响应结果
							var result = xmlHttp.responseText;
							if(result == "true"){
								setMsg("username", "用户名已存在");
							}else{
								setMsg("username", "恭喜, 用户名可以使用");
							}
						}
					}
				}
			}
		</script>
	</head>
	<body>
		<form action="#" method="POST">
			<h1>欢迎注册EasyMall</h1>
			<table>
				<tr>
					<td class="tds">用户名：</td>
					<td>
						<input type="text" name="username" onblur="ajaxCheckUsername(this)"/>
						<span id="username_msg"></span>
					</td>
				</tr>
				<tr>
					<td class="tds">密码：</td>
					<td>
						<input type="password" name="password"/>
					</td>
				</tr>
				<tr>
					<td class="tds">确认密码：</td>
					<td>
						<input type="password" name="password2"/>
					</td>
				</tr>
				<tr>
					<td class="tds">昵称：</td>
					<td>
						<input type="text" name="nickname"/>
					</td>
				</tr>
				<tr>
					<td class="tds">邮箱：</td>
					<td>
						<input type="text" name="email"/>
					</td>
				</tr>
				<tr>
					<td class="tds">验证码：</td>
					<td>
						<input type="text" name="valistr"/>
						<img src="img/regist/yzm.jpg" width="" height="" alt="" />
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
