package download;

import utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.��ȡ�������
        String filename = request.getParameter("filename");

        //2.ʹ���ֽ�����������ļ�
        //2.1�ҵ����ļ�������·��
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2���ֽ�������
        FileInputStream fis = new FileInputStream(realPath);

        //3.����response����Ӧͷ
        //3.1������Ӧͷ���ͣ�content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);

        //��������ļ�������
        //1.��ȡuser-agent����ͷ
        String agent = request.getHeader("user-agent");
        //2.ʹ�ù����෽�������ļ�������
        filename = DownLoadUtils.getFileName(agent, filename);

        //3.2������Ӧͷ�򿪷�ʽ��content-disposition
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        //4.��������������д�����������
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
