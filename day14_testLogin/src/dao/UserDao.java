package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * 操作数据库中user表中的类
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());

    /**
     * 登陆方法
     *
     * @param loginUser 只有用户名和密码
     * @return 包含用户全部数据
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
            //记录日志
            e.printStackTrace();
            return null;
        }
    }
}
