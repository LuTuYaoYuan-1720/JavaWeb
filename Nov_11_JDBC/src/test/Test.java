package test;

import dao.UserDao;
import domain.User;
import utils.JDBCUtils;

public class Test {
    @org.junit.Test
    public void testJDBCUtils() {
        JDBCUtils.insertUser("xiaoyu", "123", "123@qq.com");
    }

    @org.junit.Test
    public void testUserDao() {
        User loginUser = new User("xiaoyu", "123", "123@qq.com");
        UserDao userDao = new UserDao();
        userDao.login(loginUser);
    }

    @org.junit.Test
    public void testUserDaoLogin() {
        UserDao dao = new UserDao();
        User user = dao.login("xiaoniu", "123");
        System.out.println(user);

        User user1 = dao.login("111", "111");
        System.out.println(user1);
    }
}
