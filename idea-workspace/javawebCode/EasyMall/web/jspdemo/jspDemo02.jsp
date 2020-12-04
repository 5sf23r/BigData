<%--
  Created by IntelliJ IDEA.
  User: tedu
  Date: 2019/12/20
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="errorPage.jsp" buffer="16kb" session="true" import="java.util.Properties" language="java" %>
<html>
<head>
    <title>JSP的page指令</title>
</head>
<body>
    <h1>1.page指令的基本语法</h1>
    <p>"< %@ page"  "%>"  这就是page指令 </p>
    <p> page指令：可以定义[属性=值]的键值对 </p>
    <p> page指令：能够定义[属性=值]的键值对共有12种 </p>
    <p> [ language="java" ] ：表示页面中可以书写java代码 </p>
    <p> [ extends="package.class" ]  ：表示jsp页面可以继承一个父类 </p>
    <p> [ import="{package.class | package.*}, ..." ] :导入java代码需要使用到的包 </p>
    <p> [ session="true | false" ] :表示当前页面是否可以使用session对象
            默认情况下使用的是true
        <%= request.getSession().getAttribute("key") %>
        <%= session.getAttribute("key") %>
    </p>
    <p>
        [ buffer="none | 8kb | sizekb" ] : 表示的是响应流的缓冲区
        out.write()方法输出内容时，设置的缓冲区大小
    </p>
    <p>
        [ autoFlush="true | false" ]：表示自动刷新缓冲区
        默认情况下，是true，不需要程序干预缓冲区的刷新
    </p>
    <p>
        [ isThreadSafe="true | false" ]：表示当前的线程时单线程的
        默认为false
    </p>
    <p>
        <% int i = 1/0; %>
        [ errorPage="relative_url" ] ：表示当前页面报错时，给这页面配置一个500的错误页面
        [ isErrorPage="true | false" ] ：表示错误页面中可以使用exception对象捕获异常
    </p>
    <p>
        [ contentType="mimeType [ ;charset=characterSet ]" | "text/html ; charset=ISO-8859-1" ]
    </p>
    <p>
        [ pageEncoding="characterSet | UTF-8" ]：表示服务器在加载页面时，会使用pageEncoding进行编码
    </p>
    <p>
        [ isELIgnored="true | false" ]：表示是否忽略 el表达式
    </p>
</body>
</html>
