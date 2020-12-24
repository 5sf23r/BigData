package filter;


import javax.servlet.*;
import java.io.IOException;

/*
* 过滤器的编写步骤：
* 1. 写一个类实现 javax.servlet.Filter接口
* 2. 编写web.xml文件，配置过滤器的映射关系
* */
public class FilterDemo01 implements Filter {
    //用于过滤器的初始化工作
    //FilterConfig对应的是web.xml中配置的过滤器的映射关系，与servlet的映射类似
    //当服务器启动时加载web.xml，解析过滤器的配置信息
    //形成filterConfig对象存储于内存中
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter01 init......");
    }
    //过滤器实现业务逻辑的核心
    //filterChain：过滤器链，多个过滤器之间按照拦截顺序逐一把请求拦截
    //拦截的顺序：根据每一个过滤器的名字，按照字符串的字典顺序进行拦截
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter start......");
        //表示处理完毕当前的过滤器，会放行到下一个过滤器
        //如果没有下一个过滤器，那么会放行到请求对应的servlet中
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter end......");
    }
    //服务器关闭时，或者filter过滤器将被移除tomcat容器时，需要处理的销毁方法
    @Override
    public void destroy() {
        System.out.println("filter01 destroy......");
    }
}
