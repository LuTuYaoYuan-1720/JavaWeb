package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 测试最大连接数量
 */
public class D3P0Demo2 {
    public static void testNamedConfig() throws SQLException {
        //指定名称配置
        DataSource dataSource = new ComboPooledDataSource("mySource");
        for (int i = 0; i < 50; i++) {
            Connection conn = dataSource.getConnection();
            System.out.println(i + ":" + conn);

        }

    }

    public static void main(String[] args) throws SQLException {
        //1.获取DataSource     使用默认配置
        DataSource dataSource = new ComboPooledDataSource();
        for (int i = 0; i < 101; i++) {
            Connection conn = dataSource.getConnection();
            System.out.println(i + ":" + conn);

            if (i == 50) {
                //归还连接到连接池中
                conn.close();
            }
        }

        testNamedConfig();
    }

}
