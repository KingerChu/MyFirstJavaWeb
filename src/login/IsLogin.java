/*
package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsLogin {

    public static boolean isLogin(String username, String password) {
        boolean flag = false;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("select * from polished.student");
            rs = ps.executeQuery();//执行语句
            while (rs.next()) {//如果对象中有数据，就会循环打印出来
                String usernameDB = rs.getString("name").trim();
                String passwordDB = rs.getString("password").trim();
//                System.out.println(usernameDB+"   "+password);
                if (usernameDB.equals(username) && passwordDB.equals(password)) {
                    flag = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
        return flag;
    }

    public static boolean isUser(String username){
        boolean flag = false;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("select * from polished.student");
            rs = ps.executeQuery();//执行语句
            while (rs.next()) {//如果对象中有数据，就会循环打印出来
                String usernameDB = rs.getString("name").trim();
                if (usernameDB.equals(username)) {
                    flag = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
        return flag;
    }

}
*/
