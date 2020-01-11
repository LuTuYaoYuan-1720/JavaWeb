package servlet;

import dao.MessageDao;
import utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int result = 0;
        Connection conn = null;

        String name = request.getParameter("name");
        String title = request.getParameter("title");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>guestbook input page</title></head>");
        out.println("<body>");

        if (StringUtil.validateNull(name)) {
            out.println("对不起，姓名不能为空，请您重新输入！<br>");
            out.println("<a href=\"" + request.getContextPath() + "/addMessage.html\">添加新的留言</a><br>");
        } else if (StringUtil.validateNull(title)) {
            out.println("\"对不起，主题不能为空，请您重新输入！<br>\"");
            out.println("<a href=\"" + request.getContextPath() + "/addMessage.html\">添加新的留言</a><br>");
        } else {
            try {
                MessageDao dao = new MessageDao();
                result = dao.addMessage(name, request.getParameter("phone"), request.getParameter("email"),
                        title, request.getParameter("content"));
            } catch (Exception e) {
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
                out.println("<a href=\"" + request.getContextPath() + "/addMessage.html\">添加新的留言</a><br>");
            } else {
                out.println("祝贺您，成功添加留言。<br>");
                out.println("<a href=\"" + request.getContextPath() + "/message.jsp\">查看所有留言内容</a><br>");
            }
            out.println("</body>");
            out.println("</html>");
            out.flush();
            out.close();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
