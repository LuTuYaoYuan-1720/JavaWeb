package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 */
public class JDBCDemo10 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //2.定义sql
            String sql = "update account set balance = balance - ? where name = ?";

            String sql2 = "update account set balance = balance + ? where name = ?";


            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, 500);
            pstmt.setString(2, "zhangsan");

            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setDouble(1, 500);
            pstmt2.setString(2, "lisi");

            pstmt.executeUpdate();
            pstmt2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
            JDBCUtils.close(null, pstmt2, null);
        }
    }
}
