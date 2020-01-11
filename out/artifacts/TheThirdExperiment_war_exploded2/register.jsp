<%@ page import="dao.UserDao" %>
<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 小予‘s ThinkPad
  Date: 2019/11/25
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(username, password, email);
        UserDao dao = new UserDao();

        dao.insertUser(user);
        response.sendRedirect("/Nov_25/login.html");
    %>a
</head>
<body>

</body>
</html>
