<%@ page import="java.sql.Connection" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="util.StringUtil" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.SQLException" %>
Created by IntelliJ IDEA.
User: 小予‘s ThinkPad
Date: 2019/12/7
Time: 22:00
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddMessage</title>
    <%
        String url = "jdbc:mysql://localhost/guestbook1?useSSL=FALSE&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        String sql = "insert into book (name,email,phone,title,content,time) values(?,?,?,?,?,?)";

        int result = 0;
        Connection conn = null;

        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String title = request.getParameter("title");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head><title>guestbook input page</title></head>");
        printWriter.println("<body>");

        if (StringUtil.validateNull(name)) {
            printWriter.println("对不起，姓名不能为空，请您重新输入！<br>");
            printWriter.println("<a href=\"" + request.getContextPath() + "/addMessage.htm\">添加新的留言</a><br>");
        } else if (StringUtil.validateNull(title)) {
            printWriter.println("\"对不起，主题不能为空，请您重新输入！<br>\"");
            printWriter.println("<a href=\"" + request.getContextPath() + "/addMessage.htm\">添加新的留言</a><br>");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, password);

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, StringUtil.filterHtml(name));
                pstmt.setString(2, StringUtil.filterHtml(request.getParameter("email")));
                pstmt.setString(3, StringUtil.filterHtml(request.getParameter("phone")));
                pstmt.setString(4, StringUtil.filterHtml(title));
                pstmt.setString(5, request.getParameter("content"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                pstmt.setString(6, sdf.format(new java.util.Date()));
                result = pstmt.executeUpdate();
                pstmt.close();


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (result == 0) {
                printWriter.println("对不起，添加留言不成功，请您重新输入！<br>");
                printWriter.println("<a href=\"" + request.getContextPath() + "/addMessage.htm\">添加新的留言</a><br>");
            } else {
                printWriter.println("祝贺您，成功添加留言。<br>");
                printWriter.println("<a href=\"" + request.getContextPath() + "/GetMessage.jsp\">查看所有留言内容</a><br>");
            }
            printWriter.println("</body>");
            printWriter.println("</html>");
            printWriter.flush();
            printWriter.close();
        }
    %>
</head>
<body>

</body>
</html>
