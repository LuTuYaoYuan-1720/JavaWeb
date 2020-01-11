<%@ page import="util.StringUtil" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %>
Created by IntelliJ IDEA.
User: 小予‘s ThinkPad
Date: 2019/12/7
Time: 22:01
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetMessage</title>
    <%
        int count = 0;
        Integer objcount = (Integer) application.getAttribute("objcount");
        if (objcount != null) {
            count = objcount.intValue();
        }
        count++;
        application.setAttribute("objcount", new Integer(count));

        String url = "jdbc:mysql://localhost/guestbook1?useSSL=FALSE&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        String sql = "select * from book order by id desc";
        Connection conn = null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head><title>display messages</title></head>");
        printWriter.println("<body>");

        printWriter.println("已有&nbsp" + count + "人访问本页面<br><br>");

        printWriter.println("<a href=\"" + request.getContextPath() + "/addMessage.htm\">添加新的留言内容</a><br>");
        printWriter.println("留言内容<br><br>");
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);


            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            //若session中有已登录用户对象，就显示出所有留言
            if (request.getSession().getAttribute("msg") != null) {
                while (rs.next()) {
                    this.printRow(printWriter, rs);
                }
            } else/*否则提示登陆后才能显示*/ {
                response.sendRedirect(request.getContextPath() + "/login.html");
            }

            rs.close();
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
        printWriter.println(" </body>");
        printWriter.println("</html>");
        printWriter.flush();
        printWriter.close();
    %>
</head>
<body>

</body>
</html>

<%!
    private void printRow(PrintWriter out, ResultSet rs) throws SQLException {
        out.println("<table width=\"600\" border=\"1\" style=\"table-layout:fixed;word-break:break-all\">");
        out.println("<tr><td width=\"50\">编号</td>");
        out.println("<td width=\"550\">" + rs.getInt("id") + "</td></tr>");
        out.println("<tr><td>姓名</td><td>" + rs.getString("name") + "</td></tr>");
        out.println("<tr><td>电话</td><td>" + StringUtil.chanageNull(rs.getString("phone"), "没填") + "</td></tr>");
        out.println("<tr><td>email</td><td>" + StringUtil.chanageNull(rs.getString("email"), "没填") + "</td></tr>");
        out.println("<tr><td valign=\"top\">主题</td><td>" + rs.getString("title") + " </td></tr>");
        out.println("<tr><td valign=\"top\">内容</td>");
        out.println("<td>" + StringUtil.chanageNull(rs.getString("content"), "没填") + "</td></tr>");
        out.println("<tr><td>时间</td><td>" + rs.getString("time") + " </td></tr>");
        out.println("</table><br>");
    }
%>