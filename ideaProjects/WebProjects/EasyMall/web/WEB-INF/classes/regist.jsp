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
        /*使用jquery实现ajax*/
        $(function () {
            $("input[name='username']").blur(function () {
                var value = $("input[name='username']").val();
                console.log(value);
                //jquery实现ajax第一种
                //$("#uid_msg").load("/ajaxCheckUsername",{"username":value});
                //jquery实现ajax第二种：get方法发送请求
                //特别注意：get方法的编码格式问题
                /*$.get("/ajaxCheckUsername?username="+value,function (result) {
                console.log(result);
                //把result结果显示到span元素中
                $("#uid_msg").text(result);
                });*/
                //jquery实现ajax第三种：post方法发送请求
                /*$.post("/ajaxCheckUsername",{"username":value},function (result) {
                console.log(result);
                //把result结果显示到span元素中
                $("#uid_msg").text(result);
                });*/
                //jquery实现ajax第四种：可以自定义参数内容，比如可以指定get/post
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

            //验证码图片的切换：点击图片触发函数
            $("#img").click(function () {
                console.log(123);
                //这里改变src="xxx"路径即可
                var d1 = new Date();
                var time = d1.getTime();
                $("#img").attr("src","${pageContext.request.contextPath}/ValidateCodeServlet?time="+time);
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
                <%-- onblur的注释拿掉就是原生态，加上就是jQuery --%>
                <input <%-- onblur="AjaxCheckUsername(this)" --%> type="text" name="username" value="${username}"/>
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
                <span style="color: red">
                    <%-- <%=request.getAttribute("errorMsg6")==null?"":request.getAttribute("errorMsg6")%> --%>
                    ${errorMsg6}
                </span>
            </td>
        </tr>
        <tr>
            <td class="tds">昵称：</td>
            <td>
                <input type="text" name="nickname" value="
                <%-- <%= request.getParameter("nickname")==null?"":request.getParameter("nickname") %> --%>
                ${nickname}
                "/>
                <span style="color:red">
                    <%-- <%=request.getAttribute("errorMsg3")==null?"":request.getAttribute("errorMsg3")  %> --%>
                    ${errorMsg3}
            </span>
            </td>
        </tr>
        <tr>
            <td class="tds">邮箱：</td>
            <td>
                <input type="text" name="email" value="
                <%-- <%= request.getParameter("email")==null?"":request.getParameter("email") %> --%>
                ${email}
                " />
                <span style="color:red">
                    <%-- <%=request.getAttribute("errorMsg4")==null?"":request.getAttribute("errorMsg4")  %> --%>
                    ${errorMsg4}
                </span>
            </td>
        </tr>
        <tr>
            <td class="tds">验证码：</td>
            <td>
                <input type="text" name="valistr" value="
                <%-- <%= request.getParameter("valistr")==null?"":request.getParameter("valistr") %> --%>
                ${valistr}
                "/>
                <img id="img" src="${pageContext.request.contextPath}/ValidateCodeServlet" width="" height="" alt="" />
                <span style="color:red">
                    <%-- <%=request.getAttribute("errorMsg5")==null?"":request.getAttribute("errorMsg5")  %> --%>
                    ${errorMsg5}
                </span>
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

