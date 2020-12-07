<%@page import="cn.tedu.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <!-- EL表达式获取数据 -->
        <script type="text/javascript">
        </script>
  </head>

  <body>
    <h1>EL表达式功能1：获取数据</h1>
    <h3>获取常量</h3>
        字符型：【】<br>
        数值型：【】<br>
        布尔型：【】<br>
    <hr>
    <h3>获取变量</h3>
    <%
                // el表达式只能够获取保存在作用域中的变量
                // el表达式如果没获取到变量，不返回任何值
        // pageContext.setAttribute("name", "张三");
        request.setAttribute("name","李四");
        pageContext.setAttribute("age", 18);
        String email="abc@163.com";
        // el表达式获取变量，会使用变量名在4大作用域中
        // 从小到大依次寻找，找到就返回值，找不到则什么都不返回
        // 和pageContext.findAttribute()相似
    %>
    name=【】<br>
    age=【】<br>
    email=【】<br>

    <hr>
    <h3>获取数组中的数据</h3>
    <%
        String[] provs={"北","上","广","天"};
        pageContext.setAttribute("ps", provs);
    %>
    provs[0]=【】<br>
    provs[7]=【】<br>
  <%--   ${ps[3]="晋"} --%>
    <hr>
    <h3>获取集合中的数据</h3>
    <%
        List<String> list=new ArrayList<String>();
        list.add("刘备");
        list.add("关羽");
        list.add("张飞");
        list.add("诸葛亮");
                pageContext.setAttribute("list", list);
    %>
    list[2]=【】<br>
    list[6]=【】<br>

    <hr>
    <h3>获取map集合中的数据</h3>
    <%
        Map<String,String> map=new HashMap<String,String>();
        map.put("name", "刘备");
        map.put("age", "30");
        map.put("wife", "糜夫人");
        map.put("wife.another", "孙尚香");
        pageContext.setAttribute("map", map);
        pageContext.setAttribute("wife", "name");
    %>
    name=【】<br>
    age=【】<br>
    wife=【】<br>
        <%--     wife=${map[wife]}<br> --%>
  <%--   wife=${map.wife.another} --%>
        wife=${map["wife.another"]}
    <hr>
    <h3>获取JavaBean中的数据</h3>
    <%
        Person p1=new Person();
        p1.setName("张三丰");
        p1.setAge(120);
        p1.setAddr("武当山");
        pageContext.setAttribute("p1", p1);
    %>
    p1=【】<br>
    <!-- p1.name 被翻译成 p1.getName()  -->
    p1.name=【】<br>
    p1.addr=【】<br>
    p1.job=【】<br>
    <br><br><br><br>
  </body>
</html>
