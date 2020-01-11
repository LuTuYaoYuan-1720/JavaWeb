package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        //获取文件的服务器路径
        //web目录下的资源访问
        String b = context.getRealPath("/b.txt");
        System.out.println(b);
        //WEB-INF下的资源访问
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
