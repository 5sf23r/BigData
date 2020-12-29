<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
    <title>EasyMall欢迎您登录</title>
    <script>
        //从cookie中读取数据rename
        $(function () {

            //找到用户名input框
            //获取cookie里的值放入val方法中给用户名input框值
            $("input[name='username']").val(decodeURI("${cookie.rename.value}"));
        });
    </script>
</head>
<body>
<h1>欢迎登录EasyMall</h1>
<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
    <table>
        <tr>
            <td colspan="2" style='text-align:center;color:red'>
                <%-- 展示后台传入的提示消息 --%>
                ${errorMsg}
            </td>
        </tr>
        <tr>
            <td class="tdx">用户名：</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td class="tdx">密&nbsp;&nbsp; 码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <%-- 只有拿到了上一次勾选上记住用户名的cookie信息才能回显勾选 --%>
                <input type="checkbox" name="remname" value="true" ${(empty (cookie.rename.value)) ?"":"check='checked'"} />记住用户名
                <input type="checkbox" name="autologin" value="true"/>30天内自动登录
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center">
                <input type="submit" value="登 录"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
