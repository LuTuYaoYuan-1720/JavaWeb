package servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GBK");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.login(username, password);

        if (user != null) {
            //�ɹ���ת���ɹ�ҳ��
            request.setAttribute("userMsg", user);
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        } else {
            //��ѯʧ�����µ�½
            PrintWriter writer = response.getWriter();
            writer.print("<a href=\"/Nov_11/login.html\">�����µ�½</a>\n");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
