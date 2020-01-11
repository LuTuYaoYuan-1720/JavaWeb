package dao;

import domain.Book;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public Book getBookByBookNum(String bookNum) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Book book = null;
        try {
            String sql = "select * from bookinformation where booknumber = ?";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookNum);
            rs = pstmt.executeQuery();

            book = new Book();
            rs.next();
            book.setBookNumber(rs.getString("booknumber"));
            book.setBookTitle(rs.getString("booktitle"));
            book.setEditor(rs.getString("editor"));
            book.setPrice(rs.getInt("price"));
            book.setPublishingHouse(rs.getString("publishinghouse"));
            book.setDetail(rs.getString("detail"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    /**
     * 封装所有书籍信息
     *
     * @return
     */
    public List<Book> getAllBook() {
        List<Book> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from bookinformation";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setBookNumber(rs.getString("booknumber"));
                book.setBookTitle(rs.getString("booktitle"));
                book.setEditor(rs.getString("editor"));
                book.setPrice(rs.getInt("price"));
                book.setPublishingHouse(rs.getString("publishinghouse"));
                book.setDetail(rs.getString("detail"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

