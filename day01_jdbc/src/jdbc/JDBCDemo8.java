package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo8 {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
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
            JDBCUtils.close(null, statement, connection);
        }
    }
}
