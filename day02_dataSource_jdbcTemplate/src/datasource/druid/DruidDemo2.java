package datasource.druid;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /**
         * 给  cms 下account 添加一条数据
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into account values (null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "wangerma");
            pstmt.setDouble(2, 2500);

            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }

    }

}
