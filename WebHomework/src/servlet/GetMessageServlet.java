package servlet;

import dao.MessageDao;
import domain.Message;
import utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetMessageServlet")
public class GetMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //若session中有已登录用户对象，就显示出所有留言
        if (request.getSession().getAttribute("msg") != null) {
            Object count = request.getSession().getAttribute("count");
            if (count == null) {
                request.getSession().setAttribute("count", 1);
            } else {
                request.getSession().setAttribute("count", (Integer) count + 1);
            }

            MessageDao dao = new MessageDao();
            List<Message> allMessage = dao.getAllMessage();
            request.getSession().setAttribute("messages", allMessage);
            request.getRequestDispatcher("message_EL.jsp").forward(request, response);

        } else/*否则提示登陆后才能显示*/ {
            response.sendRedirect(request.getContextPath() + "/login.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void printRow(PrintWriter out, Message mess) {
        out.println("<table width=\"600\" border=\"1\" style=\"table-layout:fixed;word-break:break-all\">");
        out.println("<tr><td width=\"50\">编号</td>");
        out.println("<td width=\"550\">" + mess.getId() + "</td></tr>");
        out.println("<tr><td>姓名</td><td>" + mess.getName() + "</td></tr>");
        out.println("<tr><td>电话</td><td>" + StringUtil.chanageNull(mess.getPhone(), "没填") + "</td></tr>");
        out.println("<tr><td>email</td><td>" + StringUtil.chanageNull(mess.getEmail(), "没填") + "</td></tr>");
        out.println("<tr><td valign=\"top\">主题</td><td>" + mess.getTitle() + " </td></tr>");
        out.println("<tr><td valign=\"top\">内容</td>");
        out.println("<td>" + StringUtil.chanageNull(mess.getContent(), "没填") + "</td></tr>");
        out.println("<tr><td>时间</td><td>" + mess.getTime() + " </td></tr>");
        out.println("</table><br>");
    }
}
