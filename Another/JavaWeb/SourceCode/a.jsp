<%@ page session="true" contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
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
      <%=out.getClass() %>
    </p>
    <p>
      exception对象：java.lang.Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable<br/>
      <%--<%int i = 1/0;%>--%>
      需要配合其他异常页面完成
    </p>
    <hr>
  </body>
</html>
