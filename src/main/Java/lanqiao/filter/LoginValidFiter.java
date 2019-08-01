package lanqiao.filter;


import lanqiao.vo.JsonResult;
import lanqiao.vo.JsonWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/api/*")
public class LoginValidFiter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String path = request.getRequestURI();
        if("/api/login".equals(path)){
            filterChain.doFilter(request, response);
            return;
        }
        if("/api/registered".equals(path)){
            filterChain.doFilter(request, response);
            return;
        }
        HttpSession session = request.getSession(false);
        if(session!=null) {
            Object user = session.getAttribute("LoginUserKey");
            if (user!=null) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        JsonResult result= new  JsonResult("未登陆，无法访问","500","");
        JsonWriter.write(response,result);
    }

    @Override
    public void destroy() {

    }
}
