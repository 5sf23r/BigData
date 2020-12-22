<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP的基础语法</title>
</head>
<body>
<h1>1. JSP模板元素</h1>
<span>JSP页面中的所有的HTML元素，都是会被编译进入.java文件</span><br/>
<span>JSP页面中的所有的CSS+JS+数据，痛仰会被编译进入.java</span><br/>
<span>JSP页面中的所有的模板元素，最后会被编译进入servlet.java文件</span>
<hr>
<h1>2. JSP的标本表达式</h1>
<p>定义一个变量：<% int i = 0;%></p>
<p>常量：<%= 300 %></p>
<p>变量：<%= i %></p>
<p>表达式：<%= 1+1 %></p>
<p>关系运算：<%= true && false %></p>
<p>脚本表达式：会把执行的运算结果，通过out.print(值)打印到浏览器中</p>
<hr>
<h1>3. JSP的脚本片段</h1>
<p>
    <%
        for(int i = 0;i < 10;i++){
            System.out.println(i);
    %>
    <%= i %>
    <span style="color:red"><%= i %></span><br/>
    <%
        }
    %>
</p>
<p>jsp的脚本片段：可以进行阶段，阶段之后，中间可以书写HTML标签以及其他的任何样式</p>
<hr>
<h1>4. JSP的脚本声明</h1>
<p>"< %"是用于声明局部变量，在service方法有效 <% int j = 0; %></p>
<p>"< %!"是用于声明全局变量，在整个类中有效<%! int k = 0; %></p>
<p>定义成员方法：<%! public static void method(){}%></p>
<p>定义静态代码块：<%! static{}%></p>
<h1>5. JSP的注释</h1>
<p>第一种：jsp的注释，只是给程序员看的，浏览器中没有，java文件也没有，页面源代码中也没有
    <%-- 这是一个信息被注释 --%>
</p>
<p>第二种：纯java注释，能够被java文件解析到
    <%//java注释%>
</p>
<p>第三种：html注释，能够被java文件解析到，也能在浏览器源码中查看
    <!-- 这是HTML页面的注释 -->
    <!-- <%= k %> -->
    一般不要使用HTML的注释
</p>
</body>
</html>
