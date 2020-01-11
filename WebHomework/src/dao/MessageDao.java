package dao;

import domain.Message;
import utils.JDBCUtils;
import utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    /**
     * 获取所有的留言并封装至list中
     *
     * @return
     */
    public List<Message> getAllMessage() {
        List<Message> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from book order by id desc";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                Message mess = new Message();
                mess.setName(rs.getString("name"));
                mess.setPhone(rs.getString("phone"));
                mess.setEmail(rs.getString("email"));
                mess.setTitle(rs.getString("title"));
                mess.setContent(rs.getString("content"));
                mess.setTime(rs.getString("time"));
                list.add(mess);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 向留言表中添加数据
     *
     * @return 返回更改了几行
     */
    public int addMessage(String name, String phone, String email, String title, String content) {
        int result = 0;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "insert into book (name,phone,email,title,content,time) " +
                    "values (?,?,?,?,?,current_date)";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, StringUtil.filterHtml(name));
            pstmt.setString(2, StringUtil.filterHtml(phone));
            pstmt.setString(3, StringUtil.filterHtml(email));
            pstmt.setString(4, StringUtil.filterHtml(title));
            pstmt.setString(5, content);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
