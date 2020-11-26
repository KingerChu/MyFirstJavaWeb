/*
package login;

import domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDo  {
    public static ArrayList<Student> userList() {
        ArrayList<Student> userList =new ArrayList<Student>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("select * from polished.student");
            rs = ps.executeQuery();//执行语句
            while (rs.next()) {//如果对象中有数据，就会循环打印出来
                String id=rs.getString("id").trim();
                String name = rs.getString("name").trim();
                String gender = rs.getString("gender").trim();
                String age=rs.getString("age").trim();
                userList.add(new Student (id,name,gender,age));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
        return userList;
    }
}
*/
