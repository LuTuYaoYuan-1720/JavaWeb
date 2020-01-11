package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //1.创建一个图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化照片
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        //填充字母
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random ran = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(string.length());
            char ch = string.charAt(index);
            g.drawString(ch + "", i * (width / 5), height / 2);

        }

        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        //3.将图片输出到页面显示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
