package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println(request.getParameter("firstName") + request.getParameter("lastName"));

        out.println(request.getParameter("address"));
        out.println(request.getParameter("emailAddress"));
        out.println(Arrays.toString(request.getParameterValues("interest")));
        out.println(request.getParameter("question") + ":" + request.getParameter("answer"));

        out.println("<form action=\"/RegSuccess.html\">\n" +
                "    <input type=\"submit\" value=\"È·¶¨\">\n" +
                "</form>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
