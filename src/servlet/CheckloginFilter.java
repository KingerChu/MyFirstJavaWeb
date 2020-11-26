package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CheckloginFilter",urlPatterns = "/checklogin")
public class CheckloginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String referer =request.getHeader("referer");
//        System.out.println(referer);
        if(referer!=null&&(referer.contains("index.jsp")||referer.contains("/checklogin"))){
            chain.doFilter(req, resp);
        }
        else {
            response.sendRedirect("/login/index.jsp");
//           request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
