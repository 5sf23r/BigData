package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//过滤器的注解：@WebFilter
//过滤器的参数：filterName="程序员自定义的名字"
//过滤器的参数：value="/*" 代表url请求路径与filter类的映射关系
@WebFilter(filterName = "FilterDemo02",value ="/*")
public class FilterDemo02 implements Filter {
    public void destroy() {
        System.out.println("filter02 destroy......");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter02 start......");
        chain.doFilter(req, resp);
        System.out.println("filter02 end......");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter02 init......");
    }

}
