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
 * 在服务器中的Servlet中判断是否有一个名为lastTine的cookie
 * 1.有；不是第一次访问
 * 响应数据：欢迎回来，您上次访问时间为：------
 * 写回Cookie：lastTime=-------
 * 2.没有：是第一次访问
 * 响应数据：您好，欢迎首次访问
 * 写回Cookie：lastTime=----
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;

        //2.遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //3.判断名称是否为lastTime
                if ("lastTime".equals(cookie.getName())) {
                    flag = true;

                    Date data = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String strDate = sdf.format(data);

                    System.out.println("编码前" + strDate);
                    //URL编码
                    strDate = URLEncoder.encode(strDate, "utf-8");
                    System.out.println("编码后" + strDate);


                    //设置存活时间  一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    cookie.setValue(strDate);

                    //URL解码
                    String value = cookie.getValue();
                    System.out.println("解码前" + value);

                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后" + value);
                    response.getWriter().print("<h1>欢迎回来，您上次访问时间为" + value + "</h1>");
                    break;
                }
            }
        }

        //第一次访问
        if (cookies == null || cookies.length == 0 || flag == false) {
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String strDate = sdf.format(data);
            Cookie cookie = new Cookie("lastTime", strDate);

            System.out.println("编码前" + strDate);
            //URL编码
            strDate = URLEncoder.encode(strDate, "utf-8");
            System.out.println("编码后" + strDate);

            //设置存活时间  一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);
            cookie.setValue(strDate);

            response.addCookie(cookie);
            response.getWriter().print("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
