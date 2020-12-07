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
                        //1.页面在加载时，需要通过request对象先获取cookie信息
                        Cookie[] cookies = request.getCookies();
                        Cookie targetcookie = null;
                        if (cookies!=null) {
                                for (Cookie temp : cookies) {
                                        if (temp.getName().equals("remname")) {
                                                targetcookie = temp;
                                                break;
                                        }
                                }
                        }
                        //获取targetcookie中的用户名
                        String username = "";
                        if (targetcookie!=null) {
                                username = targetcookie.getValue();
                                username = URLDecoder.decode(username, "utf-8");
                                //将username添加到input文本框回显
                        }
                %>
                <h1>欢迎登录EasyMall</h1>
                <form action="/login" method="POST">
                        <table>
                                <tr>
                                        <td colspan="2" style='text-align:center;color:red'><%=request.getAttribute("errorMsg")==null?"":request.getAttribute("errorMsg")%></td>
                                </tr>
                                <tr>
                                        <td class="tdx">用户名：</td>
                                        <td><input type="text" name="username" value="<%=username%>"  /></td>
                                </tr>
                                <tr>
                                        <td class="tdx">密&nbsp;&nbsp; 码：</td>
                                        <td><input type="password" name="password"/></td>
                                </tr>
                                <tr>
                                        <td colspan="2">
                                                <input type="checkbox"  name="remname" value="true" <%= targetcookie==null?"":"checked"%> />记住用户名
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
