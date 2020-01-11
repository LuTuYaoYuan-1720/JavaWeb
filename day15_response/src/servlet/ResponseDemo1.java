package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1  ....");

/*        //访问 /ResponseDemo1  会自动跳转至  /ResponseDemo2
        //1.设置状态码为302
        response.setStatus(302);
        // 2.设置响应头 location
        response.setHeader("location", "/day15/ResponseDemo2");*/

        //动态获取虚拟目录
        String contextPath = request.getContextPath();

        //简单的重定向方法
        response.sendRedirect(contextPath + "/ResponseDemo2");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
