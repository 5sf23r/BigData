<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>九大隐式对象概述</h1>
<p>
    所谓隐式对象就是：程序员无需自定义对象，这些对象由jsp-servlet的API内部实现和封装
</p>
<p>
    page对象：final java.lang.Object page = this，不常用 <br/>
    <%= page.getClass() %>
</p>
<p>
    config对象：final javax.servlet.ServletConfig config;<br/>
    <%= config.getInitParameterNames()%>
</p>
<p>
    application对象：final javax.servlet.ServletContext application;<br/>
    <%= application.getInitParameter("test")%>
</p>
<p>
    response对象：final javax.servlet.http.HttpServletResponse response<br/>
    <%= response.getContentType()%>
</p>
<p>
    request对象：javax.servlet.http.HttpServletRequest request <br/>
    <%=request.getSession().getId()%>

</p>
<p>
    session对象：javax.servlet.http.HttpSession session <br/>
    <%= session.getId() %>
</p>
<p>
    out对象：javax.servlet.jsp.JspWriter out  ; <br/>
    <%=out.getClass()%>
</p>
<p>
    exception对象：java.lang.Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable<br/>
    <%--<%int i = 1/0;%>--%>
    需要配合其他异常页面完成
</p>
<p>
    pageContext对象：javax.servlet.jsp.PageContext pageContext<br/>
    <%=pageContext.getClass()%>
</p>
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
    session.setAttribute("key", "session-value");
    application.setAttribute("key", "application-value");
    request.setAttribute("key", "request-value");
    pageContext.setAttribute("key", "pagecontext-value");
%>
session-key:<%=pageContext.getAttribute("key",PageContext.SESSION_SCOPE)%><br>
application-key:<%=pageContext.getAttribute("key",PageContext.APPLICATION_SCOPE)%><br>
request-key:<%=pageContext.getAttribute("key",PageContext.REQUEST_SCOPE)%><br>
pagecontext-key:<%=pageContext.getAttribute("key",PageContext.PAGE_SCOPE)%>
<h3>2.pagecontext对象：查找四大域对象的属性键值对</h3>
顺序1--pageContext：<%=pageContext.findAttribute("key")%><br>
删除pageContext中的key：<%pageContext.removeAttribute("key",PageContext.PAGE_SCOPE);%><br>
顺序2--Request：<%=pageContext.findAttribute("key")%><br>
删除Request中的key：<%pageContext.removeAttribute("key",PageContext.REQUEST_SCOPE);%><br>
顺序3--session：<%=pageContext.findAttribute("key")%><br>
删除session中的key：<%pageContext.removeAttribute("key", PageContext.SESSION_SCOPE);%><br>
顺序4--application：<%=pageContext.findAttribute("key")%><br>
删除application中的key：<%pageContext.removeAttribute("key", PageContext.APPLICATION_SCOPE);%><br>
如果都找不到：<%=pageContext.findAttribute("key")%><br>
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
