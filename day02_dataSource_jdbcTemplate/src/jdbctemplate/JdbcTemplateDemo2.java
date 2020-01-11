package jdbctemplate;

import domain.Account;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 1.修改一号数据的 balance 为 20000
     */
    @Test
    public void test1() {
        //1.创建template对象
        //2.定义sql
        String sql = "update account set balance = 20000 where id = 1";
        int account = template.update(sql);

        System.out.println(account);
    }

    /**
     * 2.添加一条记录
     */
    @Test
    public void test2() {

        String sql = "insert into account values (?,?,?)";

        int count = template.update(sql, 4, "zhaosi", 3800);

        System.out.println(count);
    }

    /**
     * 3.删除之前添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from account where id = ?";
        int count = template.update(sql, 4);
        System.out.println(count);
    }

    /**
     * 4.查询id为1的记录，封装为map
     * 查询的结果集长度只能是1，将列明做为key ，值作为value
     */
    @Test
    public void test4() {
        String sql = "select * from account where id = ?";

        Map<String, Object> map = template.queryForMap(sql, 1);
        // {id=1, name=zhangsan, balance=20000.0}
        System.out.println(map);
    }

    /**
     * 5.查询所有记录，封装为list
     */
    @Test
    public void test5() {
        String sql = "select * from account";

        List<Map<String, Object>> list = template.queryForList(sql);

        list.forEach((map) -> System.out.println(map));
    }

    /**
     * 6.查询所有记录，将其封装为account对象的list集合
     */
    @Test
    public void test6() {
        String sql = "select * from account";
//        List<Account> list = template.query(sql, new RowMapper<Account>() {
//
//            @Override
//            public Account mapRow(ResultSet rs, int i) throws SQLException {
//                Account account = new Account(rs.getInt("id"),
//                        rs.getString("name"), rs.getDouble("balance"));
//
//                return account;
//            }
//        });

        List<Account> list = template.query(sql, new BeanPropertyRowMapper<>(Account.class));
        list.forEach(System.out::println);
    }

    /**
     * 7.查询所有记录数
     */
    @Test
    public void test7() {
        String sql = "select count(id) from account";

        Long total = template.queryForObject(sql, Long.class);

        System.out.println(total);
    }
}
