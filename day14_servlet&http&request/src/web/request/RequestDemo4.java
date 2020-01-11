package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //referer �������Ի�ȡ���ĸ�ҳ����뵽��ҳ��
        String referer = request.getHeader("referer");

        System.out.println(referer);
        //http://localhost/day14/login.html
        //����
        if (referer != null) {
            if (referer.contains("/day14")) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("welcome to you ku");
                //System.out.println("��ӭ�����ſ�");
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("��Ҫ���������ӽ���");
                //System.out.println("��Ҫ���������ӽ���");
            }
        }
    }
}
