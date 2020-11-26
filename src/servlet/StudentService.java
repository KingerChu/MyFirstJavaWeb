package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/studentser")
public class StudentService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        System.out.println(req.getRequestURI());
        /*if (req.getRequestURI().contains("/main.jsp")){
        }*/

        String gender=req.getParameter("gender");
        UserService.selByGender(req.getSession(),gender);
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
/*    public ArrayList<Student> fingStuByGender(ArrayList<Student> studentlist,String gender){
        List<Student> studentlist=new ArrayList();
        studentlist.add(new Student("1","xiaoming","nan","22"));
        studentlist.add(new Student("2","xiaoli","nan","24"));
        studentlist.add(new Student("3","xiaosas","nan","25"));
        studentlist.add(new Student("4","xiaoasdg","nv","27"));

        if(gender==null){
            return studentlist;
        }else {
            ArrayList<Student> studentlistPass=new ArrayList();
            for (int i = 0; i < studentlist.size(); i++) {
                if(studentlist.get(i).getGender().equals(gender)){
                    studentlistPass.add(studentlist.get(i));
                    System.out.println(studentlist.get(i).getName());
                }
            }
            return studentlistPass;

        }
    }*/
}
