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
        //设置编码
        request.setCharacterEncoding("utf-8");
/*        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装对象
        User loginUser = new User();
        loginUser.setPassword(password);
        loginUser.setUsername(username);*/

        //获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        //创建User对象
        User loginUser = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(loginUser);

        //调用UserDao的login
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);


        if (user == null) {
            //登录失败
            request.getRequestDispatcher("/FailServlet").forward(request, response);
        } else {
            //登录成功
            request.setAttribute("user", user);
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
