package utils;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
    ���������ļ�
     */
    static {
        try {
            //1.����properties������
            Properties pro = new Properties();
            //��ȡsrc·���µ��ļ��ķ�ʽ----->ClassLoader  �������
            ClassLoader classLoader = util.JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");

            String path = resource.getPath();
            /*System.out.println(path);*/
            //2.�����ļ�
            pro.load(new FileReader(path));

            //3.��ȡ���ݣ���ֵ
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.ע������
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ����
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
     * �ͷ���Դ
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
