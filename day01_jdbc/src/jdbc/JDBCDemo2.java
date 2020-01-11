package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * studentinfo表 添加一条记录
 */
public class JDBCDemo2 {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义sql
            String sql = "insert into studentinfo values ('3','wangwu',23)";
            //3.获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cms?useSSL=FALSE&serverTimezone=UTC", "root", "root");
            //4.获取执行sql的对象，Statement
            statement = connection.createStatement();
            //5.执行sql
            int count = statement.executeUpdate(sql);
            //6.处理结果
            if (count > 0) {
                System.out.println("添加成功！！");
            } else {
                System.out.println("添加失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //避免空指针异常
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
