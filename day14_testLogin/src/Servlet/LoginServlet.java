package Servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ñ���
        request.setCharacterEncoding("utf-8");
/*        //��ȡ�������
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //��װ����
        User loginUser = new User();
        loginUser.setPassword(password);
        loginUser.setUsername(username);*/

        //��ȡ�����������
        Map<String, String[]> map = request.getParameterMap();
        //����User����
        User loginUser = new User();
        //ʹ��BeanUtils��װ
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(loginUser);

        //����UserDao��login
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);


        if (user == null) {
            //��¼ʧ��
            request.getRequestDispatcher("/FailServlet").forward(request, response);
        } else {
            //��¼�ɹ�
            request.setAttribute("user", user);
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
