package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.��ȡ����ʽ
        String method = request.getMethod();
        System.out.println(method);
        //2.(*) ��ȡ����Ŀ¼
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.��ȡServlet·��
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4.��ȡget��ʽ�������
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5.(*)��ȡ����URI
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //6.��ȡЭ��汾
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7.��ȡ�ͻ���IP��ַ
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);

    }
}
