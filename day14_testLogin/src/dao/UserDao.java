package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * �������ݿ���user���е���
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());

    /**
     * ��½����
     *
     * @param loginUser ֻ���û���������
     * @return �����û�ȫ������
     */
    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";

            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        } catch (Exception e) {
            //��¼��־
            e.printStackTrace();
            return null;
        }
    }
}
