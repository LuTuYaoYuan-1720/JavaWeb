package jdbc;

import java.sql.*;

public class JDBCDemo7 {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cms?useSSL=FALSE&serverTimezone=UTC", "root", "root");
            //3.定义sql
            String sql = "select * from studentinfo";
            //4.获取执行sql的对象
            statement = connection.createStatement();
            //5.执行sql
            set = statement.executeQuery(sql);
            //6.处理结果
            //判断游标是否为最后一行末尾
            while (set.next()) {
                String id = set.getString(1);
                String name = set.getString("name");
                int age = set.getInt("age");
                System.out.println(id + "---" + name + "---" + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
