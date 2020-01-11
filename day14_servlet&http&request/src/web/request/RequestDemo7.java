package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RequestDemo7")
public class RequestDemo7 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //中文乱码问题
        //get  方式：tomcat 8 已经将get 方式乱码问题解决了
        //post  方式：会乱码  解决 ：在获取参数前设置request编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数username
        String username = request.getParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
