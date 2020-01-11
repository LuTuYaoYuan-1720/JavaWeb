package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //user-agent  中包含浏览器的信息  后期可以恨据解析出来的浏览器信息解决兼容性问题
        String header = request.getHeader("user-agent");
        if (header.contains("Chrome")) {
            System.out.println("来自谷歌");
        } else if (header.contains("Edge")) {
            System.out.println("来自IE");
        }
    }
}
