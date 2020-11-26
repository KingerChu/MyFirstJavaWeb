package servlet;

import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Filtercheck implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.println("filter init");
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        /*String cookiename = null;
        String cookiepass = null;
        Cookie[] cookies=request.getCookies();
        for (int i=0;i<cookies.length;i++){
            if(cookies[i].getName().equals("user")){
                cookiename=(String) cookies[i].getValue();
            }else if(cookies[i].getName().equals("pass")){
                cookiepass=(String) cookies[i].getValue();
            }
        }*/
        if(request.getRequestURI().contains("/index.jsp")||request.getRequestURI().contains("/checkcode")||request.getRequestURI().contains("/registered.jsp")||request.getRequestURI().contains("/checklogin")||request.getRequestURI().contains(".jpg")||request.getRequestURI().contains("/regser")){
            chain.doFilter(req, resp);
//            System.out.println(request.getRequestURI());
        }
        else if(UserService.isInCookie(request.getCookies())){
//            UserService.addUserList(request.getSession());
            chain.doFilter(req, resp);
//            response.sendRedirect("/login/welcome.jsp");
//            System.out.println("跳转欢迎界面cookie");
        }
        else {
            response.sendRedirect("/login/index.jsp");
//           request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
