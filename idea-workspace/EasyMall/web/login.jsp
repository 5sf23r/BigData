<%--
  Created by IntelliJ IDEA.
  User: coe
  Date: 2020/11/24
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*"   pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css"/>
    <title>EasyMall欢迎您登陆</title>
</head>
<body>
<h1>欢迎登陆EasyMall</h1>
<form action="<%=request.getContextPath()%>/LoginServlet" method="POST">
    <table>
        <%
            Cookie remnameC = null;
            Cookie[] cs = request.getCookies();
            if(cs != null){
                for(Cookie c:cs){
                   if("remname".equals(c.getName())){
                       remnameC = c;
                   }
                }
            }
            String username = "";
            if(remnameC != null){
                username = URLDecoder.decode(remnameC.getValue(),"utf-8");
            }
        %>
        <tr>
            <td class="tds" colspan=2 style="color:red;text-align:center">
                <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
            </td>
        </tr>
        <tr>
            <td class="tdx">用户名：</td>
            <td><input type="text" name="username" value="<%=username%>"/></td>
        </tr>
        <tr>
            <td class="tdx">密&nbsp;&nbsp; 码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="checkbox" name="remname" value="true" <%= username==""?"":"checked='checked'"%>/>记住用户名
                <input type="checkbox" name="autologin" value="true"/>30天内自动登陆
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center">
                <input type="submit" value="登 陆"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>