<%@ page session="true" contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <hr>
    <h1>pageContext对象：作为入口对象获取其他八种隐式对象：</h1>
    <p>
      <br/>
      作为入口对象获取其他八种隐式对象：<br/>
      pageContext.getException()=<%=pageContext.getException()%><br/>
      pageContext.getPage()=<%=pageContext.getPage()%><br/>
      pageContext.getRequest()=<%=pageContext.getRequest()%><br/>
      pageContext.getResponse()=<%=pageContext.getResponse()%><br/>
      pageContext.getServletConfig()=<%=pageContext.getServletConfig()%><br/>
      pageContext.getServletContext()=<%=pageContext.getServletContext()%><br/>
      pageContext.getPage()=<%=pageContext.getPage()%><br/>
      pageContext.getSession()=<%=pageContext.getSession()%>
    </p>
    <hr>
    <h2>pagecontext对象：作为入口对象,四大域对象属性</h2>
    <p>
      request域对象常量PageContext.REQUEST_SCOPE：<%=PageContext.REQUEST_SCOPE%><br/>
      session域对象常量PageContext.SESSION_SCOPE：<%=PageContext.SESSION_SCOPE%><br/>
      application域对象常量PageContext.APPLICATION_SCOPE：<%=PageContext.APPLICATION_SCOPE%><br/>
      page域对象常量PageContext.PAGE_SCOPE：<%=PageContext.PAGE_SCOPE%>
    </p>
    <hr>
    <h2>pagecontext对象：操作所有域中属性的方法</h2>
    <p>
      <h3>1.pagecontext对象：获取attribute属性键值对</h3>
      <%
        //session三种写法
        session.setAttribute("key", "session-value");
        pageContext.setAttribute("key","session-value",PageContext.SESSION_SCOPE);
        pageContext.getSession().setAttribute("key","session-value");
        //application三种写法
        application.setAttribute("key", "application-value");
        pageContext.setAttribute("key","application-value",PageContext.APPLICATION_SCOPE);
        pageContext.getSession().setAttribute("key","application");
        //request三种写法
        request.setAttribute("key", "request-value");
        //pageContext三种写法
        pageContext.setAttribute("key", "pagecontext-value");
        %>
      session-key:<%=pageContext.getAttribute("key",PageContext.SESSION_SCOPE)%><br>
      application-key:<%=pageContext.getAttribute("key",PageContext.APPLICATION_SCOPE)%><br>
      request-key:<%=pageContext.getAttribute("key",PageContext.REQUEST_SCOPE)%><br>
      pagecontext-key:<%=pageContext.getAttribute("key",PageContext.PAGE_SCOPE)%>
      <h3>2.pagecontext对象：查找四大域对象的属性键值对</h3>
      顺序1--pageContext：【<%=pageContext.findAttribute("key")%>】<br>
      <%-- removeAttribute方法：如果不指定scope，它将删除四大作用域对象的key --%>
      删除pageContext中的key：【<%pageContext.removeAttribute("key",PageContext.PAGE_SCOPE);%>】<br>
      <%-- getAttribute方法：前提：remove不能删除所有的域，不然无法获取；
           如果不指定scope，它不能自动的去其他域获取key-value --%>
      <%-- findAttribute方法：自动的注意搜索四大域对象，从小到大的顺序 --%>
      顺序2--Request：【<%=pageContext.findAttribute("key")%>】<br>
      删除Request中的key：【<%pageContext.removeAttribute("key",PageContext.REQUEST_SCOPE);%>】<br>
      顺序3--session：【<%=pageContext.findAttribute("key")%>】<br>
      删除session中的key：【<%pageContext.removeAttribute("key", PageContext.SESSION_SCOPE);%>】<br>
      顺序4--application：【<%=pageContext.findAttribute("key")%>】<br>
      删除application中的key：【<%pageContext.removeAttribute("key", PageContext.APPLICATION_SCOPE);%>】<br>
      如果都找不到：【<%=pageContext.findAttribute("key")%>】<br>
      <h3>3.pagecontext对象：作为域对象使用：默认查找顺序即可</h3>
      <%request.setAttribute("key1", "value1");%>
      <%=pageContext.findAttribute("key1")%>
      <h3>4.pagecontext对象：跳转到其他资源</h3>
      <%pageContext.forward("../index.jsp");%>
    </p>
    <h1></h1>
    <hr>
    <h1></h1>
    <hr>
  </body>
</html>
