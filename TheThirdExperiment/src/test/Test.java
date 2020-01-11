package test;

import dao.UserDao;
import domain.User;

public class Test {

    public static void main(String[] args) {
        User user = new User("xiao", "123", null);

        UserDao userDao = new UserDao();
        System.out.println(userDao.existUser(user));

    }
}
