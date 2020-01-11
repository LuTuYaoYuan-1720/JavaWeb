package jdbc;

import util.JDBCUtils;

import java.sql.*;

/**
 * 键盘输入用户名与密码
 * 判断是否登录成功
 */
public class JDBCDemo9 {

    /**
     * 使用Statement实现
     */
    public static boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        } else {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                conn = JDBCUtils.getConnection();

                stmt = conn.createStatement();

                String sql = "select * from user where username = '" + username + "'and password = '" + password + "'";

                System.out.println(sql);
                rs = stmt.executeQuery(sql);

                //判断是否有下一行
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(rs, stmt, conn);
            }
        }
        return false;
    }


    /**
     * 使用PrepareStatement'实现        防止SQL注入，效率更高
     */
    public static boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        } else {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                conn = JDBCUtils.getConnection();
                String sql = "select * from user where username =  ?  and password = ? ";

                pstmt = conn.prepareStatement(sql);
                //给？赋值
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                rs = pstmt.executeQuery();

                //判断是否有下一行
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(rs, pstmt, conn);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(login("xiaoyui", "a' or 'a' = 'a"));

        System.out.println(login2("xiaoyu", "123"));
    }
}
