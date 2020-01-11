package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        ��ȡServletContext����
        1.ͨ��request��ȡ
        2.ͨ��HttpServlet��ȡ
         */

        ServletContext servletContext = req.getServletContext();

        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext == servletContext1);
        System.out.println(servletContext);
        System.out.println(servletContext1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
