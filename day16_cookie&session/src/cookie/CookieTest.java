package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �ڷ������е�Servlet���ж��Ƿ���һ����ΪlastTine��cookie
 * 1.�У����ǵ�һ�η���
 * ��Ӧ���ݣ���ӭ���������ϴη���ʱ��Ϊ��------
 * д��Cookie��lastTime=-------
 * 2.û�У��ǵ�һ�η���
 * ��Ӧ���ݣ����ã���ӭ�״η���
 * д��Cookie��lastTime=----
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.��ȡ����Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;

        //2.����cookie����
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //3.�ж������Ƿ�ΪlastTime
                if ("lastTime".equals(cookie.getName())) {
                    flag = true;

                    Date data = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
                    String strDate = sdf.format(data);

                    System.out.println("����ǰ" + strDate);
                    //URL����
                    strDate = URLEncoder.encode(strDate, "utf-8");
                    System.out.println("�����" + strDate);


                    //���ô��ʱ��  һ����
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    cookie.setValue(strDate);

                    //URL����
                    String value = cookie.getValue();
                    System.out.println("����ǰ" + value);

                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("�����" + value);
                    response.getWriter().print("<h1>��ӭ���������ϴη���ʱ��Ϊ" + value + "</h1>");
                    break;
                }
            }
        }

        //��һ�η���
        if (cookies == null || cookies.length == 0 || flag == false) {
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
            String strDate = sdf.format(data);
            Cookie cookie = new Cookie("lastTime", strDate);

            System.out.println("����ǰ" + strDate);
            //URL����
            strDate = URLEncoder.encode(strDate, "utf-8");
            System.out.println("�����" + strDate);

            //���ô��ʱ��  һ����
            cookie.setMaxAge(60 * 60 * 24 * 30);
            cookie.setValue(strDate);

            response.addCookie(cookie);
            response.getWriter().print("<h1>���ã���ӭ���״η���</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
