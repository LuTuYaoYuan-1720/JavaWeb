<%@ page import="dao.UserDao" %>
<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 小予‘s ThinkPad
  Date: 2019/11/25
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <%
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        User loginUser = new User(username, password, null);
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        if (user != null) {
            request.setAttribute("msg", user);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }
    %>
</head>
<body>

</body>
</html>
