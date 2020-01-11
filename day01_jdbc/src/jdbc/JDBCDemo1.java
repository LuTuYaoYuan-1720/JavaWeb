package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author 小予‘s ThinkPad
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {

        //1.导入jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //3.获取数据库的连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cms?useSSL=FALSE&serverTimezone=UTC", "root", "root");
        //4.定义sql语句
        String sql = "update studentinfo set age = 20 where id = 1";
        //5.获取执行sql语句的对象
        Statement statement = conn.createStatement();
        //6.执行sql
        int count = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        statement.close();
        conn.close();
    }
}
