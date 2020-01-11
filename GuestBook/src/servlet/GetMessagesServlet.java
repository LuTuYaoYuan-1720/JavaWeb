package servlet;

import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/GetMessagesServlet")
public class GetMessagesServlet extends HttpServlet {
    private static final long serialVersionUID = 5964428201228635704L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost/guestbook1?useSSL=FALSE&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        String sql = "select * from book order by id desc";
        Connection conn = null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>display messages</title></head>");
        out.println("<body>");
        out.println("<a href=\"" + request.getContextPath() + "/addMessage.htm\">添加新的留言内容</a><br>");
        out.println("留言内容<br><br>");
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			conn = DriverManager.getConnection("jdbc:odbc:guestbook");

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                this.printRow(out, rs);
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        out.println(" </body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    private void printRow(PrintWriter out, ResultSet rs) throws SQLException {
        out.println("<table width=\"600\" border=\"1\" style=\"table-layout:fixed;word-break:break-all\">");
        out.println("<tr><td width=\"50\">编号</td>");
        out.println("<td width=\"550\">" + rs.getInt("id") + "</td></tr>");
        out.println("<tr><td>姓名</td><td>" + rs.getString("name") + "</td></tr>");
        out.println("<tr><td>电话</td><td>" + StringUtil.chanageNull(rs.getString("phone"), "没填") + "</td></tr>");
        out.println("<tr><td>email</td><td>" + StringUtil.chanageNull(rs.getString("email"), "没填") + "</td></tr>");
        out.println("<tr><td valign=\"top\">主题</td><td>" + rs.getString("title") + " </td></tr>");
        out.println("<tr><td valign=\"top\">内容</td>");
        out.println("<td>" + StringUtil.chanageNull(rs.getString("content"), "没填") + "</td></tr>");
        out.println("<tr><td>时间</td><td>" + rs.getString("time") + " </td></tr>");
        out.println("</table><br>");
    }
}
