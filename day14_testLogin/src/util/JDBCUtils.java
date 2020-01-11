package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC ������  ʹ�õ�ʱDruid
 */
public class JDBCUtils {
    private static DataSource ds;

    /*
      ���������ļ�
      ��ʼ�����ӳ�
     */
    static {
        try {
            //���������ļ�
            Properties pro = new Properties();
            //ʹ��ClassLoader���������ļ�    ��ȡ�ֽ�������
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //��ʼ�����ӳض���
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ӳض���
     *
     * @return
     */
    public static DataSource getDs() {
        return ds;
    }

    /**
     * ��ȡ����Connection ����
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
