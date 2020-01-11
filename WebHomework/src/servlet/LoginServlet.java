package servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("username");
        String pwd = request.getParameter("password");
        UserDao dao = new UserDao();
        boolean login = dao.login(uname, pwd);
        //��½�ɹ�
        if (login) {
            User user = new User();
            user.setUsername(uname);
            user.setPassword(pwd);
            request.getSession().setAttribute("msg", user);
            response.sendRedirect(request.getContextPath() + "/addMessage.html");
        } else/*��½ʧ��*/ {
            response.getWriter().print("<a href=\"" + request.getContextPath() + "/login.html\">�����µ�½</a>\n");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
