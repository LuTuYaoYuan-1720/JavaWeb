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
        //user-agent  �а������������Ϣ  ���ڿ��Ժ޾ݽ����������������Ϣ�������������
        String header = request.getHeader("user-agent");
        if (header.contains("Chrome")) {
            System.out.println("���Թȸ�");
        } else if (header.contains("Edge")) {
            System.out.println("����IE");
        }
    }
}
