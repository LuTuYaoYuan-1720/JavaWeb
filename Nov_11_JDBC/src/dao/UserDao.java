package dao;

import domain.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
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
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insertUser(String username, String password, String email) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            String sql = "insert  into user (username,password,email) values (?,?,?)";
            connection = JDBCUtils.getConnection();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
