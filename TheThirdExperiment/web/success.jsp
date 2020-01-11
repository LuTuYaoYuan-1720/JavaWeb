<%@ page import="domain.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>success</title>
    <%
        User user = (User) request.getAttribute("msg");
        response.getOutputStream().print(user.getUsername()+"  login success");
    %>
</head>
<body>

</body>
</html>