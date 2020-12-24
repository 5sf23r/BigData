<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.Person" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<br>
    <h1>c:set标签 赋值</h1>
    <h3>向四大作用域中增加域属性 page/request/session/application</h3>
    <%-- var：绑定的键值对的key value：绑定的键值对的值 scope：四大域对象范围 --%>
    <%
        request.setAttribute("username","张三丰");
    %>
    <c:set value="张三丰" var="username" scope="request"></c:set>
    <c:set var="name" value="林黛玉" scope="request"></c:set>
    name=【${requestScope.name}】<br>
    username=【${requestScope.username}】
    <hr>
    <h3>向map中增加、修改键值对</h3>
    <%
        Map<String,String> map=new HashMap<String,String>();
        map.put("name", "刘备");
        map.put("wife", "甘夫人");
        pageContext.setAttribute("map", map);
    %>
    <!-- 修改键值对的值 -->
    <%-- property value target --%>
    <c:set property="wife" value="孙尚香" target="${map}"></c:set>
    name=【${map.name}】<br>
    wife=【${map["wife"]}】<br>
    <!-- 向map集合中添加键值对 -->
    <c:set property="son" value="刘禅" target="${map}"></c:set>
    son=【${map["son"]}】<br>

    <hr>
    <h3>修改javabean的属性</h3>
    <%
        Person p1=new Person("林黛玉",18,"大观园");
        pageContext.setAttribute("p1", p1);
    %>
    <c:set property="name" value="薛宝钗" target="${p1}" ></c:set>
    p1=【${p1}】
    <hr>
    <br><br><br><br><br>
<%-- 总结：set标签中：共有5个属性
     var：变量
     scope：域对象的范围
     property：对象中属性的名称，map中的key
     value：对象中属性的值，map中的value
     target：表示目标对象！！！
 --%>
</body>
</html>
