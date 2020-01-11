package utils;

import java.sql.*;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
    加载配置文件
     */
    static {
        try {
            url = "jdbc:mysql://localhost/guestbook?useSSL=FALSE&serverTimezone=UTC";
            user = "root";
            password = "root";
            driver = "com.mysql.cj.jdbc.Driver";

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }


    public static void insertUser(String username, String password, String email) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            String sql = "insert  into user (username,password,email) values (?,?,?)";
            connection = getConnection();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     *
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
