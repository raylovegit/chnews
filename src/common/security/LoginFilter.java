/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rslee
 * @data 2010-3-23
 * 说明：这个LoginFiter有如下的功能：
 * 过滤指定的路径的非法请求
 * web.xml文件配置如下：
 * <filter>
        <filter-name>Login</filter-name>
        <filter-class>security.LoginFilter</filter-class>
        <init-param>
            <param-name>url</param-name>
            <param-value>p404.jsp</param-value>
        </init-param>
        <init-param>
            <param-name>ext</param-name>
            <param-value>login.jsp,p404.jsp,loginServlet.jsp</param-value>
        </init-param>
        <init-param>
            <param-name>name</param-name>
            <param-value>user</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>Login</filter-name>
        <url-pattern>/security/*</url-pattern>
    </filter-mapping>
 */
public class LoginFilter implements Filter {

    private String name;
    private String url;
    private String ext;//例外

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        boolean flag = false;
        //请求的是例外的页面
       
        for(String e:parseExt(ext)){
            if(uri.indexOf(e)!=-1){
                flag = true;
            }
        }
        System.out.println("过滤器执行中：uri"+uri);
        System.out.println("过滤器执行中：flag"+flag);
        System.out.println("过滤器执行中：user"+session.getAttribute(name));
        System.out.println("过滤器执行中：url"+url);
        if(flag){
            chain.doFilter(request, response);
        }
        else if (session.getAttribute(name) != null) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        //这里用于从web.xml文件里面获取参数
        name = filterConfig.getInitParameter("name");
        url = filterConfig.getInitParameter("url");
        ext = filterConfig.getInitParameter("ext");
        System.out.println("过滤器初始化url："+url+",name:"+name+",ext:"+ext);
    }
    //根据","分割多个例外的请求
    public String [] parseExt(String ext){
        return ext.split(",");
    }

    public void destroy() {
        System.out.println("LoginFiter销毁");
    }
}
