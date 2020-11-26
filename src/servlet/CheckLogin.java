package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/checklogin")
public class CheckLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String checkcode=req.getParameter("checkword");
        String serverCheckcode =(String)req.getSession().getAttribute("checkcode");

        if (UserService.isUserService(username,password)&&serverCheckcode.equals(checkcode)){
            UserService.addUserCookie(resp,username,password);
/*            Cookie usercookie=new Cookie("user", username);
            Cookie passcookie=new Cookie("pass", password);
            resp.addCookie(usercookie);
            resp.addCookie(passcookie);

            ArrayList<Student> userList = UserDo.userList();
            req.getSession().setAttribute("userlist",userList);*/
            UserService.addUserList(req.getSession());
            resp.sendRedirect("/login/welcome.jsp");

//            req.getRequestDispatcher("/welcome.jsp").forward(req,resp);
//            System.out.println("跳转欢迎界面 登录");
        }
        else if(UserService.isInCookie(req.getCookies())){
            /*req.getSession().setAttribute("user",cookiename);
            ArrayList<Student> userList = UserDo.userList();
            req.getSession().setAttribute("userlist",userList);*/
            UserService.addUserList(req.getSession());
            resp.sendRedirect("/login/welcome.jsp");
//            req.getRequestDispatcher("/welcome.jsp").forward(req,resp);
//            System.out.println("跳转欢迎界面");
        }
        else{
            req.setAttribute("loginerror","error");
            req.getRequestDispatcher("index.jsp").forward(req,resp);

        }


    }
}
