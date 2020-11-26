package servlet;

import domain.Student;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/regser")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        String id= String.valueOf(System.currentTimeMillis());
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String gender=req.getParameter("sex" );
        String age=req.getParameter("age" );
        boolean flag=true;

        String Checkcode = req.getParameter("validateCode");//接收客户端浏览器提交上来的验证码

        String serverCheckcode =(String)req.getSession().getAttribute("checkcode");
//        System.out.println(serverCheckcode);
        if (Checkcode.equals(serverCheckcode)) {//将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
            System.out.println("验证码验证通过！");
            if(name==null||name==""){
                System.out.println("用户名为空！");
                req.setAttribute("nameerror","用户名为空！");
                flag=false;
            }
            else if(!UserService.isUserService(name)){
                Student student = new Student(id,name,gender,age);
                flag= UserService.adduser(student,password);

                /*Connection conn = DBUtil.getConnection();
                PreparedStatement preStmt = null;
                try {
                    preStmt = (PreparedStatement) conn.prepareStatement("insert into polished.student values(?,?,?,?,?)");
                    preStmt.setString(1, id);
                    preStmt.setString(2, name);
                    preStmt.setString(3, password);
                    preStmt.setString(4, gender);
                    preStmt.setString(5, age);
                    preStmt.executeUpdate();
                    preStmt.close();
                    DBUtil.closeConnection(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }*/

//                System.out.println(name);
//                System.out.println(sex);
            }else {
                System.out.println("用户名已存在！");
                req.setAttribute("nameerror","用户名已存在！");
                flag=false;

            }
        }else {
            System.out.println("验证码验证失败！");
            req.setAttribute("codeerror","验证码验证失败！");
            flag=false;
        }

        if(flag){
            System.out.println("注册成功");
            UserService.addUserCookie(resp,name,password);
/*            Cookie usercookie=new Cookie("user", name);
            resp.addCookie(usercookie);
            ArrayList<Student> userList = UserDo.userList();
            req.getSession().setAttribute("userlist",userList);*/
            UserService.addUserList(req.getSession());
            resp.sendRedirect("/login/welcome.jsp");
//            req.getRequestDispatcher("/welcome.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("registered.jsp").forward(req,resp);
        }
    }
}