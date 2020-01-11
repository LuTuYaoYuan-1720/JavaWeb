package test;


import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        System.out.println(user);
    }
}
