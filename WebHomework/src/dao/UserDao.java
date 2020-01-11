package dao;

import utils.JDBCUtils;

import java.sql.*;

public class UserDao {

    /**
     * 查询此用户是否存在
     *
     * @param username
     * @param password
     */
    public boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select  * from user where username = ? and password  = ?";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 用户表中插入数据
     * @param username
     * @param password
     * @param email
     * @param phone
     */
    public void addUser(String username, String password, String email, String phone) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "insert into user (username,password,email,phone,regdate) " +
                    "values (?,?,?,?,current_date)";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
