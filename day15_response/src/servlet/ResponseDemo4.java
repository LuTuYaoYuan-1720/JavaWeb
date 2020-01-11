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
        //��ȡ������֮ǰ����������Ĭ�ϱ���
        //response.setCharacterEncoding("GBK");

        //��������������������͵���Ϣ�����ݵı��룬���������ʹ��
        //response.setHeader("content-type", "text/html;charset=utf-8");

        //�򵥵���ʽ
        response.setContentType("text/html;charset=utf-8");

        //1.��ȡ�ַ������
        PrintWriter pw = response.getWriter();

        //2.�������
        pw.write("��� response");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
