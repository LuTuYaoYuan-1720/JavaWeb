package servlet;

import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


@WebServlet("/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {

    private static final long serialVersionUID = -8349454122547148005L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost/guestbook1?useSSL=FALSE&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        String sql = "insert into book (name,email,phone,title,content,time) values(?,?,?,?,?,?)";

//		String sql = "";		
        int result = 0;
        Connection conn = null;

        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String title = request.getParameter("title");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>guestbook input page</title></head>");
        out.println("<body>");

        if (StringUtil.validateNull(name)) {
            out.println("对不起，姓名不能为空，请您重新输入！<br>");
            out.println("<a href=\"" + request.getContextPath() + "/guestbook/addMessage.htm\">添加新的留言</a><br>");
        } else if (StringUtil.validateNull(title)) {
            out.println("\"对不起，主题不能为空，请您重新输入！<br>\"");
            out.println("<a href=\"" + request.getContextPath() + "/guestbook/addMessage.htm\">添加新的留言</a><br>");
        } else {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, password);

//				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//				conn = DriverManager.getConnection("jdbc:odbc:guestbook");				

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, StringUtil.filterHtml(name));
                pstmt.setString(2, StringUtil.filterHtml(request.getParameter("email")));
                pstmt.setString(3, StringUtil.filterHtml(request.getParameter("phone")));
                pstmt.setString(4, StringUtil.filterHtml(title));
                pstmt.setString(5, request.getParameter("content"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                pstmt.setString(6, sdf.format(new java.util.Date()));
                result = pstmt.executeUpdate();
                pstmt.close();

//				String email = request.getParameter("email");
//				String phone = request.getParameter("phone");
//				String content = request.getParameter("content");
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//				String dt = sdf.format(new java.util.Date());
//			    Statement stmt = conn.createStatement();
//			    sql = "insert into book(name,phone,email,title,content,time) values( '" + name + "','" + phone + "','" + email + "','" + title + "','" + content 
//                    + "','" + dt + "' )" ;
//				result = stmt.executeUpdate(sql);				

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
            if (result == 0) {
                out.println("对不起，添加留言不成功，请您重新输入！<br>");
                out.println("<a href=\"" + request.getContextPath() + "/addMessage.htm\">添加新的留言</a><br>");
            } else {
                out.println("祝贺您，成功添加留言。<br>");
                out.println("<a href=\"" + request.getContextPath() + "/GetMessagesServlet\">查看所有留言内容</a><br>");
            }
            out.println("</body>");
            out.println("</html>");
            out.flush();
            out.close();
        }
    }
}
