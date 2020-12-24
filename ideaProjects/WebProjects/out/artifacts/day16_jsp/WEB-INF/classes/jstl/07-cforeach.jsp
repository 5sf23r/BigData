<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>c:forEach标签 实现循环</h1>
<h3>增强for循环</h3>
    <%
        List<String> list=new ArrayList<String>();
        list.add("宋江");
        list.add("吴用");
        list.add("卢俊义");
        list.add("武松");
        pageContext.setAttribute("list", list);
    /*    	for(String str:list){


            } */
    %>
<c:forEach items="${list}" var="str" >
    name=${str}<br>
</c:forEach>
<hr>

<h3>普通for循环</h3>
<%
    for (int i = 0;i<10;i++){
        System.out.println(i);
    }
%>
<%--
varStatus：变量名是程序员自定义的
当前循环的状态：
index:索引从0开始
cout：次数从1开始
first：循环的第一个参数,是否为第一行
--%>
<c:forEach begin="0" end="10" step="1" varStatus="s">
    <span>Hello JSTL</span>;index=${s.index};cout=${s.count};first=${s.first};last=${s.last}<br/>
</c:forEach>
<hr>

<h3>遍历10到100的偶数，如果数字所在的位置是3的倍数， 显示成红色</h3>
<c:forEach begin="10" end="100" var="temp" varStatus="vs" >
    <%-- 特别注意：不能出现额外的空格，而别是在if语句的test判断中 --%>
    <c:if test="${temp % 2==0 }">
        <span style="color: green">${vs.count}</span>
        <c:if test="${vs.count%3!=0}">
            <span>${temp}</span><br/>
        </c:if>
        <c:if test="${vs.count%3==0}">
            <span style="color: red">${temp}</span><br/>
        </c:if>
    </c:if>
</c:forEach>
<br><br><br><br><br>
</body>
</html>
