package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * �ض���
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1  ....");

/*        //���� /ResponseDemo1  ���Զ���ת��  /ResponseDemo2
        //1.����״̬��Ϊ302
        response.setStatus(302);
        // 2.������Ӧͷ location
        response.setHeader("location", "/day15/ResponseDemo2");*/

        //��̬��ȡ����Ŀ¼
        String contextPath = request.getContextPath();

        //�򵥵��ض��򷽷�
        response.sendRedirect(contextPath + "/ResponseDemo2");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
