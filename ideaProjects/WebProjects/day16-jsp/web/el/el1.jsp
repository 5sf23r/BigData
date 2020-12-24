<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="pojo.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>el概述</h1>
<p>
    EL 全名为Expression Language，用来替代"< % =" "%>"脚本表达式 <br>
    EL具有获取数据、执行运算、获取常用开发对象、调用java方法这四方面的功能
</p>
<h1>1. el获取常量</h1>
<p>
    <%-- \${} 相当于el表达式的一个注释 --%>
    \${"张三"}:【${"张三"}】<br/>
    \${123}:【${123}】<br/>
    \${true}:【${true}】
</p>
<h1>2. el获取变量</h1>
<p>
<h2>2.1 在四大作用域查找属性</h2>
<%
    session.setAttribute("key1", "session-value");
    application.setAttribute("key2", "application-value");
    request.setAttribute("key3", "request-value");
    pageContext.setAttribute("key4", "pagecontext-value");
%>
\${key1}:【${key1}】<br/>
\${key2}:【${key2}】<br/>
\${key3}:【${key3}】<br/>
\${key4}:【${key4}】
</p>
<p>
<h2>2.2 获取指定域中的属性</h2>
<%
    session.setAttribute("hello1", "session-value");
    application.setAttribute("hello1", "application-value");
    request.setAttribute("hello1", "request-value");
    pageContext.setAttribute("hello1", "pagecontext-value");
%>
\${hello1}:【${hello1}】<br/>
\${requestScope.hello1}:【${requestScope.hello1}】<br/>
\${sessionScope.hello1}:【${sessionScope.hello1}】<br/>
\${applicationScope.hello1}:【${applicationScope.hello1}】
</p>
<p>
<h2>2.3 获取数组中的数据</h2>
<%
    String[] strings = {"一", "二", "三", "四"};
    pageContext.setAttribute("arr", strings);
%>
<%-- <%=strings[7]%> 原生态的写法，如果数组越界会产生异常--%>
\${arr[0]}:【${arr[0]}】<br/>
<%-- el表达式：遇到null或者数组越界时，会自动处理结果，不会出现异常 --%>
\${arr[0]}:【${arr[7]}】
</p>
<p>
<h2>2.4 获取集合中的数据</h2>
<%
    List<String> lists = new ArrayList<String>();
    lists.add("刘备");
    lists.add("关于");
    lists.add("张飞");
    lists.add("曹操");
    pageContext.setAttribute("lists", lists);
%>
<%-- 表达式会自动进行null的处理，不出现异常 --%>
\${lists[0]}:【${lists[0]}】<br/>
\${lists[3]}:【${lists[3]}】<br/>
</p>
<p>
<h2>2.5 获取map中的数据</h2>
<%
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", "刘备");
    map.put("age", "30");
    map.put("wife", "糜夫人");
    map.put("wife.another", "孙尚香");
    pageContext.setAttribute("map", map);
    pageContext.setAttribute("wife", "name");
%>
\${map.name}:【${map.name}】<br/>
\${map.age}:【${map.age}】<br/>
\${map.wife}:【${map.wife}】<br/>
<%--\${map.wife.another}:${map.wife.another}<br/>--%>
\${map["wife.another"]}:【${map["wife.another"]}】<br/>

</p>
<p>
<h2>2.6 获取javabean属性</h2>
<%
    Person p1 = new Person();
    p1.setName("张三丰");
    p1.setAge(120);
    p1.setAddr("武当山");
    pageContext.setAttribute("p1", p1);
    Person p2 = new Person();
    p2.setName("张无忌");
    p2.setAge(12);
    p2.setAddr("明教");
    pageContext.setAttribute("p2", p2);
%>
<%-- 此处的p1：指的是setAttribute()中的key，而不是变量名p1 --%>
\${p1}:【${p1}】<br>
\${p1.name}:【${p1.name}】<br>
\${p1.addr}:【${p1.addr}】<br>
\${p1.age}:【${p1.age}】<br>
</p>
<h1>3. el获取数据细节</h1>
<p>
<h3>3.1 关系运算：lt gt ne eq </h3>
1&lt;2=【${1 lt 2}】<br>
1&gt;2=【${1 gt 2}】<br>
<%
    pageContext.setAttribute("p1", new Person());
    pageContext.setAttribute("p2", new Person());
%>
p1==p2? 【${p1 ne p2}】<br>
p1!=p2? 【${p1 eq p2}】
<hr>
</p>
<p>
<h3>3.2 empty运算符</h3>
<%
    // 判断对象是否为null
    //Person p3=null;
    Person p3 = new Person();
    pageContext.setAttribute("p3", p3);
    // 判断字符串是否为空串
    pageContext.setAttribute("str", "");
    // 判断数组是否没有初始化
    String[] array = new String[10];
    pageContext.setAttribute("array", array);
    // 判断集合中没有添加任何元素
    List<String> list = new ArrayList(20);
    // 判断作用域中是否有元素
    // pageScope/requestScope/sessionScope/
    // applicationScope
    // 以上4个对象代表的是四大作用域的集合
    pageContext.setAttribute("list", list);
    // application.setAttribute("123", 123);
    // application.removeAttribute("123");
    // session.setAttribute("111", 111);
    session.removeAttribute("111");
%>
判断对象是否为null：【${empty p3}】<br>
判断字符串是否为空串：【${empty str}】<br>
判断数组是否没有初始化：【${empty array}】<br>
判断集合中没有添加任何元素：【${empty list}】<br>
判断作用域中是否有元素：【${empty sessionScope}】<br>
</p>
<p>
<h3>三目运算符 布尔表达式?表达式1:表达式2</h3>
【${1 lt 2 ? "1 lt 2":"1 gt 2" }】
<hr>
</p>
<h1>4. 获取数据细节</h1>
<p>
<h3>.和[]区别：使用点的地方都可以用中括号， 如果属性名是数字或包含特殊符号（.-）就必须使用中括号 。例子：\${map["first.name"]}</h3>
<h3>EL只能获取不能设置</h3>
<h3>EL只能获取不能遍历</h3>
</p>
<h1>5. el获取web开发常用对象</h1>
<p>
    El中预先定义了11个内置对象，不需要提前存入域中个，可以直接在el使用
</p>
<p>
<h3>5.1 .代表了4大作用域上的map集合的4个对象</h3>
<!-- 4大作用域对象 pageContext,request,session,application -->
<!-- pageScope/requestScope/sessionScope/applicationScope -->
<!-- 上面这4个对象本身就是map集合，分别代表了4大作用域对象身上的map集合 -->
<%
    pageContext.setAttribute("fruit", "apple");
    pageContext.setAttribute("fruit", "orange", PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("fruit", "banana", PageContext.SESSION_SCOPE);
    pageContext.setAttribute("fruit", "watermelon", PageContext.APPLICATION_SCOPE);
    pageContext.setAttribute("name", "张三");
%>
pageContext:【${fruit}】<br>
request:【${requestScope.fruit}】<br>
session:【${sessionScope.fruit}】<br>
application:【${applicationScope.fruit}】<br>
name:【${pageScope.name}】<br>
</p>
<p>
<h3>5.2 .请求参数组成的map</h3>
<h3>代表了请求参数的map集合的2个对象 param paramValues</h3>
name=<%=request.getParameter("name") %><br>
<%-- 原生态写法，没有处理对象为null时，抛出的异常 --%>

<%--like=<%=request.getParameterValues("like")[0] %><br>
    like=<%=request.getParameterValues("like")[1] %><br>
    like=<%=request.getParameterValues("like")[2] %><br>
--%>
name=【${param.name}】<br>
like=【${paramValues.like[0]}】<br>
like=【${paramValues.like[1]}】<br>
like=【${paramValues.like[2]}】<br>
<hr>
</p>
<p>
<h3>5.3 .请求头组成的map</h3>
<h3>代表了请求头数据的map集合的2个对象 header headerValues</h3>
host=【<%=request.getHeader("host") %>】<br>
cookie=【${headerValues.cookie[0]}】<br>
<hr>
<hr>
</p>
<p>
<h3>5.4 .web应用初始化参数组成的map</h3>
<h3>代表了所有Cookie的map集合: cookie.JSESSIONID.</h3>
<%
    Cookie[] cs = request.getCookies();
    Cookie c1 = cs[0];
    String name = c1.getName();
    String value = c1.getValue();
%>
cookie-name=【${cookie.JSESSIONID.name}】
cookie-value=【${cookie.JSESSIONID.value}】
<hr>
</p>
<p>
<h3>5.5 .所有cookie信息组成的map:initParam</h3>
<%--
<context-param>
    <param-name>hellokey</param-name>
    <param-value>hellovalue</param-value>
</context-param>
<context-param>
    <param-name>job</param-name>
    <param-value>IT</param-value>
</context-param>
 --%>
<h3>代表了web.xml中配置的初始化参数</h3>
hellovalue=【${initParam.hellokey}】<br>
job=【${initParam.job}】<br>
</p>
</body>
</html>
