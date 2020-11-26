/*
package login;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection(){
        Connection conn =null;
        final String DB_URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
        final String USER = "root";
        final String PASS = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn)  {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs)  {
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closePreparedStatement(PreparedStatement ps)  {
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeStatement(PreparedStatement psmt)  {
        try {
            psmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
*/
