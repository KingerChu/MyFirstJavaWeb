package Dao;

import BD.DBUtilsPool;
import domain.Student;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {

    public static boolean isUsers(String username, String password){
        boolean flag = false;
        int i=0;
        JdbcTemplate template= null;
        template = new JdbcTemplate(DBUtilsPool.getDataSource());
        Object[] objects=new Object[]{username,password};
        i=template.queryForObject("select count(*) from polished.student where name=? and password =?",objects,Integer.class);
        if(i==1){
            flag=true;
        }
        return flag;
    }
    public static boolean isUsers(String username){
        boolean flag = false;
        int i=0;
        JdbcTemplate template= null;
        template = new JdbcTemplate(DBUtilsPool.getDataSource());
        i=template.queryForObject("select count(*) from polished.student where name=?",new Object[]{username},Integer.class);
        if(i!=0){
            flag=true;
        }
        return flag;
    }

    public static boolean addUsers(Object[] addUser){
        boolean flag=false;
        JdbcTemplate template= null;
        template = new JdbcTemplate( DBUtilsPool.getDataSource());
        int i= template.update("insert into polished.student values(?,?,?,?,?) ",addUser);
        if(i==1){
            flag=true;
        }
        return flag;
    }

    public static List<Student> userList() {
        JdbcTemplate template = new JdbcTemplate(DBUtilsPool.getDataSource());
        BeanPropertyRowMapper<Student> mapper = new BeanPropertyRowMapper(Student.class);
        List<Student> userList=template.query("select id,name,gender,age from polished.student", mapper);
        return userList;
    }
}
