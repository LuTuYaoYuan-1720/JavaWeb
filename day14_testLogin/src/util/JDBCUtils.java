package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC 工具类  使用的时Druid
 */
public class JDBCUtils {
    private static DataSource ds;

    /*
      加载配置文件
      初始化连接池
     */
    static {
        try {
            //加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件    获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     *
     * @return
     */
    public static DataSource getDs() {
        return ds;
    }

    /**
     * 获取连接Connection 对象
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
