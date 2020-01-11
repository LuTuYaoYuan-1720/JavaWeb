package test;

import dao.BookDao;
import dao.MessageDao;
import dao.UserDao;

public class Test {
    @org.junit.Test
    public void testUserLogin() {
        UserDao dao = new UserDao();
        System.out.println(dao.login("xiaoyu", "123"));
    }


    @org.junit.Test
    public void testAddUser() {
        UserDao dao = new UserDao();
        dao.addUser("yu", "4134", "rqreqw@163.com", "123151");
    }

    @org.junit.Test
    public void testAddMessage() {
        MessageDao dao = new MessageDao();
        dao.addMessage("fhasjd", "5412415", "tuqp@qq.com", "hello", "hgalkhdgshgsahgas");
    }

    @org.junit.Test
    public void testBookDaoGetAllBook() {
        BookDao dao = new BookDao();
        dao.getAllBook().forEach(System.out::println);
    }


    @org.junit.Test
    public void testBookDaoGetOneBookByBookNum() {

        BookDao dao = new BookDao();
        System.out.println(dao.getBookByBookNum("412"));
    }
}
