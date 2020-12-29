<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>欢迎注册EasyMall</title>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="css/regist.css"/>
    <script src="js/ajax.js"></script>
    <script src="js/jquery-1.4.2.js"></script>

    <script>
        function ajaxCheckUsername(obj) {
            //1.获取文本框输入的内容value值
            var value = obj.value;
            console.log(value);
            //2.创建一个XMLHttpRequest对象
            var xr = ajaxFunction();
            //2.1 查看状态码： 0 表示对象刚刚创建，还没有使用
            console.log(xr.readyState);
            //3.使用xr对象，发送一个请求HttpRequest，会发送到服务器端
            //open()方法是打开与服务器的连接
            xr.open("post","/AjaxCheckUsername",true);
            console.log(xr.readyState);//状态码： 1 表示open方法调用了
            //4. 需要把参数添加到request请求中
            xr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xr.send("username="+value);
            console.log(xr.readyState);//状态码： 2 表示发送了参数
            //5. 等待request请求发送到服务器端，服务器端处理完毕，返回结果
            //添加一个监听器，专门监听服务器端的响应
            xr.onreadystatechange = function () {
                console.log(xr.readyState);//状态码：3 表示开始响应，响应未结束
                if (xr.readyState==4) {//状态码：4 表示响应结束
                    //判断：response对象响应的状态码：200 成功，404/500 错误
                    if (xr.status == 200) {//响应成功
                        console.log(xr.status);
                        //获取响应的数据内容
                        var result = xr.responseText;
                        console.log(result);
                        document.getElementById("uid_msg").innerText=result;
                    } else if(xr.status==404) {//资源路径错误
                        console.log(xr.status);
                    } else {//服务器错误
                        console.log(xr.status);
                    }
                }
            }
        }
    </script>
    <script>
        $(function () {
            $("input[name='username']").blur(function () {
                var value = $("input[name='username']").val();
                console.log(value);
                $.ajax({
                    url:"/AjaxCheckUsername",
                    data:"username="+value,
                    type:"post",//请求的方式
                    async:true,//异步的请求。可以省略
                    //dataType:json,//数据格式json。可以省略
                    success:function (result) {//成功后，响应结果
                        //把result结果显示到span元素中
                        $("#uid_msg").text(result);
                    },
                    error:function () {//url资源路径不存在
                        $("#uid_msg").text("服务器404错误");
                    }
                });
            });
            /*非空校验*/
            function checkNull(name,msg) {
                //拼接传入的name属性值
                var tag=$("input[name='"+name+"']").val();
                //清空
                $("input[name='"+name+"']").nextAll
                ("span").text("");
                if(tag==""){
                    //提示信息
                    $("input[name='"+name+"']").nextAll
                    ("span").text(msg);
                    //进了判断说明数据不正确不能提交数据
                    return false;
                }
                return true;
            }

            /*校验密码一致*/
            function checkpassword() {
                //获取两次密码的值
                var password=$("input[name='password']").val();
                var password2=$("input[name='password2']").val();
                //判断两次是否一致
                if(password!=""&&password2!=""&&password!=password2){
                    $("input[name='password2']").nextAll
                    ("span").text("两次密码不一致");
                    return false;
                }
                return true;
            }

            /*校验邮箱格式*/
            function checkemail() {
                //---/\w+@\w+(\.\w+)+/
                var reg=/\w+@\w+(\.\w+)+/;
                var email=$("input[name='email']").val();
                if(email!=""&&!reg.test(email)){
                    $("input[name='email']").nextAll
                    ("span").text("邮箱格式不正确");
                    return false;
                }
                return  true;
            }
            //文档就绪事件
            $(function () {
                //给密码绑定离焦事件
                $("input[name='password']").blur(function () {
                    checkNull("password","密码不能为空")
                });
                //给确认密码绑定离焦事件
                $("input[name='password2']").blur(function () {
                    checkNull("password2","确认密码不能为空")
                    checkpassword();
                });
                //给昵称绑定离焦事件
                $("input[name='nickname']").blur(function () {
                    checkNull("nickname","昵称不能为空")
                });
                //邮箱
                $("input[name='email']").blur(function () {
                    checkNull("email","邮箱不能为空")
                    checkemail();
                });
                //给验证码绑定离焦事件
                $("input[name='valistr']").blur(function () {
                    checkNull("valistr","验证码不能为空")
                });
                //验证码图片的切换：点击图片触发函数
                $("#img").click(function () {
                    console.log(123);
                    //这里改变src="xxx"路径即可
                    var d1 = new Date();
                    var time = d1.getTime();
                    $("#img").attr("src","${pageContext.request.contextPath}/ValidateCodeServlet?time="+time);
                });
            });
        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="POST">
    <h1>欢迎注册EasyMall</h1>
    <table>
        <tr>
            <td class="tds">用户名：</td>
            <td>
                <input type="text" name="username" value="${username}"/>
                <span id="uid_msg" style="color: red">
                    ${errorMsg1}
                </span>
            </td>
        </tr>
        <tr>
            <td class="tds">密码：</td>
            <td>
                <input type="password" name="password" />
                <span style="color: red">
                    ${errorMsg2}
                </span>
            </td>
        </tr>
        <tr>
            <td class="tds">确认密码：</td>
            <td>
                <input type="password" name="password2" />
                <span style="color: red">${errorMsg6}</span>
            </td>
        </tr>
        <tr>
            <td class="tds">昵称：</td>
            <td>
                <input type="text" name="nickname" value="${nickname}"/>
                <span style="color:red">${errorMsg3}</span>
            </td>
        </tr>
        <tr>
            <td class="tds">邮箱：</td>
            <td>
                <input type="text" name="email" value="${email}" />
                <span style="color:red">${errorMsg4}</span>
            </td>
        </tr>
        <tr>
            <td class="tds">验证码：</td>
            <td>
                <input type="text" name="valistr" />
                <img id="img" src="${pageContext.request.contextPath}/ValidateCodeServlet" width="" height="" alt="" />
                <span style="color:red">${errorMsg5}</span>
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

