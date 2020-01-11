package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ͨ�õĻ�ȡ���������ʽ  get  post' ������

        //���ݲ���ֵ���ƻ�ȡ����ֵ
        String username = request.getParameter("username");
        System.out.println("post  +  " + username);

        //���ݲ������ƻ�ȡ����ֵ������
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //��ȡ���в����Ĳ�������
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("-------");
        }
        //��ȡ���еĲ�������
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((s, strings) -> System.out.println(s + "-----" + Arrays.toString(strings)));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
