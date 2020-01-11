package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码
        //response.setCharacterEncoding("GBK");

        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用
        //response.setHeader("content-type", "text/html;charset=utf-8");

        //简单的形式
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = response.getWriter();

        //2.输出数据
        pw.write("你好 response");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
