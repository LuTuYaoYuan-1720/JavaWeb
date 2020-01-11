package web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2 implements Servlet {
    /**
     * ��ʼ������
     * ��servlet������ʱ��ִ�У�ִֻ��һ��
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init .....");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * �ṩ���񷽷�
     * ÿһ��Servlet������ʱ��ִ�У�ִ�ж��
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service ......");
    }

    /**
     * ��ȡservlet��Ϣ
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * �ڷ����������ر�ʱִ�У�ִ��һ��
     */
    @Override
    public void destroy() {
        System.out.println("destroy ....");
    }
}
