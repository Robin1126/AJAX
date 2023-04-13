package de.tu_ilmenau.ajax.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Author : Binbin Luo
 * Date : 11.04.2023
 */
public class DBUtil {
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.info");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String username = bundle.getString("username");
    private static String password = bundle.getString("password");
    private static ThreadLocal<Connection> local = new ThreadLocal<>();

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 工具类隐藏构造方法
    private DBUtil() {}

    // 获取Connection方法
    public static Connection getConnection() throws SQLException {
        // ThreadLocal是一个绑定conn和线程的容器
        Connection conn = local.get();
        if (conn == null) {
            // 当前线程没有connection就新建
            conn = DriverManager.getConnection(url, username, password);
            // 新建完毕以后存入ThreadLocal当中
            local.set(conn);
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs)  {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
                local.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
