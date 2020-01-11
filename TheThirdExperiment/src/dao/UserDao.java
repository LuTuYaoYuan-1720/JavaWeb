package dao;

import domain.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean existUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from user where username = ?";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());

            rs = pstmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User login(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from user where username = ? and password = ?";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public User login(User loginUser) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select  * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loginUser.getUsername());
            pstmt.setString(2, loginUser.getPassword());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                return new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email" +
                                ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insertUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            String sql = "insert  into user (username,password,email) values (?,?,?)";
            connection = JDBCUtils.getConnection();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
