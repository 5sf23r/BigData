<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tarena
  Date: 2019/12/23
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <c:forEach begin="0" end="4" step="1" varStatus="vs">
        HELLO JSTL~~~index=${vs.index},count=${vs.count},first=${vs.first}<br>
    </c:forEach>
    <hr>

    <h3>遍历10到100的偶数，如果数字所在的位置是3的倍数，
        显示成红色</h3>
    <c:forEach begin="10" end="100" step="2" var="num" varStatus="vs2" >
        <c:if test="${vs2.count%3==0}" var="flag">
            <font style="color:red">${num} </font>
        </c:if>
        <c:if test="${!flag}">
            <font style="color:blue">${num} </font>
        </c:if>
    </c:forEach>
    <br><br><br><br><br>
</body>
</html>
