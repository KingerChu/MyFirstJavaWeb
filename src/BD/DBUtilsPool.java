package BD;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.*;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtilsPool {

    private static DataSource ds=null;

    static{
        Properties p=new Properties();
        try {
            p.load(DBUtilsPool.class.getClassLoader().getResourceAsStream("dbpool.properties"));
            ds= DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static void close(Connection conn, Statement stat){
        close(conn,stat,null);
    }

    public static void close(Connection conn, Statement stat, ResultSet rs){
        if(null!=rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=stat) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=conn)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
