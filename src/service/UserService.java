package service;

import Dao.UserDao;
import domain.Student;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static boolean isUserService(String username, String password){
        boolean flag=UserDao.isUsers(username, password);
        return flag;
    }
    public static boolean isUserService(String username){
//        if(username!=null||username!="")
        boolean flag= UserDao.isUsers(username);
        return flag;
    }

    public static void addUserList(HttpSession session){
        List<Student> userList = UserDao.userList();
        session.setAttribute("userlist",userList);
    }

    public static void selByGender(HttpSession session,String gender){

//        ArrayList<Student> studentlist1=this.fingStuByGender(studentlist,sessionGender);
        if(gender==null||gender.equals("")){
            UserService.addUserList(session);
        }else {
            List<Student> studentlist= UserDao.userList();
            List<Student> studentlistPass=new ArrayList();
            for (int i = 0; i < studentlist.size(); i++) {
                if(studentlist.get(i).getGender().equals(gender)){
                    studentlistPass.add(studentlist.get(i));
//                    System.out.println(studentlist.get(i).getName());
                }
            }
            session.setAttribute("userlist",studentlistPass);
        }
    }

    public static void addUserCookie(HttpServletResponse resp,String username, String password){
        Cookie usercookie=new Cookie("user", username);
        Cookie passcookie=new Cookie("pass", password);
        resp.addCookie(usercookie);
        resp.addCookie(passcookie);
    }

    public static void removecookie(HttpServletRequest req, HttpServletResponse resp){
        Cookie usercookie = new Cookie("user",null);//cookie名字要相同
        Cookie passcookie = new Cookie("pass",null);//cookie名字要相同
        usercookie.setMaxAge(0);
        passcookie.setMaxAge(0);
        usercookie.setPath(req.getContextPath());  // 相同路径
        passcookie.setPath(req.getContextPath());  // 相同路径
        resp.addCookie(usercookie);
        resp.addCookie(passcookie);
    }

    public static boolean isInCookie(Cookie[] cookies){
        boolean flag=false;
        String cookiename = null;
        String cookiepass = null;
        int cookieLength = 0;
        if(cookies!=null){
            cookieLength=cookies.length;
        }
        for (int i=0;i<cookieLength;i++){
            if(cookies[i].getName().equals("user")){
                cookiename= cookies[i].getValue();
            }else if(cookies[i].getName().equals("pass")){
                cookiepass= cookies[i].getValue();
            }
        }
/*        System.out.println(cookiename);
        System.out.println(cookiepass);*/
        if(UserDao.isUsers(cookiename,cookiepass)){
            flag=true;
        }
        return flag;
    }
    public static boolean adduser(Student student, String password){
        boolean flag =false;
        String id =student.getId();
        String name =student.getName();
        String gender =student.getGender();
        String age =student.getAge();
        Object[] addUser =new Object[]{id,name,password,gender,age};
        if(password!=""&&gender!=null&&age!=null){
            flag =UserDao.addUsers(addUser);
        }

        if(!flag)
            System.out.println("插入数据失败！");
        return flag;
    }

}
