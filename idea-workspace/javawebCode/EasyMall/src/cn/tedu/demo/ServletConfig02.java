package cn.tedu.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*initParams 对应着  配置文件所有的<init-param>标签*/
/*@WebInitParam 对应着  其中一个<init-param>*/
/*name 对应着  <param-name>标签 */
/* value 对应着 <param-value> 标签 */
@WebServlet(value="/config02",initParams = {
        @WebInitParam(name="encoding",value = "utf-8"),
        @WebInitParam(name="key3",value="value3")
})
public class ServletConfig02 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取一个ServletConfig对象
        // 该对象对应着 web.xml中 <servlet>中的配置信息
        // 该对象只是对 当前的servlet对象来说的，其他的servlet对象没有关系
        ServletConfig servletConfig = this.getServletConfig();
        //2. 使用API中的方法，获取初始化的配置信息key与value
        // 2.1 该方法 参数为 key ，返回值为value，结果只有一个value
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.println(encoding);
        //req.setCharacterEncoding(encoding);

        //2.2 该方法 返回当前servlet中所有的配置信息，key:value的键值对信息
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String key = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(key);
            System.out.println("key:"+key+"   value:"+value);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
