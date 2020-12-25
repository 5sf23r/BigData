<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="css/login.css"/>
    <title>EasyMall欢迎您登录</title>
</head>
<body>
<%
    //全局变量用于回显
    String username ="";
    //1. 获取所有的cookies
    Cookie[] cookies = request.getCookies();
    //2. 判断其中是否有username的cookie
    if(cookies!=null && cookies.length>=1){
        for(Cookie cookie:cookies){
            if("username".equals(cookie.getName())){
                String value = cookie.getValue();
                value = URLDecoder.decode(value,"utf-8");
                username = value;
                System.out.println("cookie中的名字："+username);
                break;
            }
        }
    }
%>
<h1>欢迎登录EasyMall</h1>
<form action="/LoginServlet" method="POST">
    <table>
        <tr>
            <td colspan="2" style='text-align:center;color:red'><%=request.getAttribute("errorMsg")==null?"":request.getAttribute("errorMsg")%></td>
        </tr>
        <tr>
            <td class="tdx">用户名：</td>
            <td><input type="text" name="username" value="<%=username %>"  /></td>
        </tr>
        <tr>
            <td class="tdx">密&nbsp;&nbsp; 码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="checkbox"
                        <%="".equals(username)?"":"checked='checked'" %>
                       name="remname" value="true"/>记住用户名
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
