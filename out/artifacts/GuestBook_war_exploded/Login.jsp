<%@ page import="domain.User" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: 小予‘s ThinkPad
  Date: 2019/12/9
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        String url = "jdbc:mysql://localhost/guestbook1?useSSL=FALSE&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from user where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            String uname = request.getParameter("username");
            String pwd = request.getParameter("password");
            pstmt.setString(1, uname);
            pstmt.setString(2, pwd);

            ResultSet resultSet = pstmt.executeQuery();
            //登陆成功
            if (resultSet.next()) {
                request.getSession().setAttribute("msg", new User(resultSet.getString("username"),
                        resultSet.getString("password")));
                response.sendRedirect(request.getContextPath() + "/addMessage.htm");
            } else/*登陆失败*/ {
                response.getWriter().print("<a href=\"" + request.getContextPath() + "/login.html\">请重新登陆</a>\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    %>
</head>
<body>

</body>
</html>
