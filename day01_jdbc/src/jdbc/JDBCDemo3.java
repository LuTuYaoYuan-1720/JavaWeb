package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改记录
 */
public class JDBCDemo3 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/cms?useSSL=FALSE&serverTimezone=UTC", "root", "root");

            String sql = "update studentinfo set age = 30 where id = '3' ";

            statement = connection.createStatement();

            int count = statement.executeUpdate(sql);

            System.out.println(count);

            if (count>0) {
                System.out.println("修改成功！！");
            }else{
                System.out.println("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection!= null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
