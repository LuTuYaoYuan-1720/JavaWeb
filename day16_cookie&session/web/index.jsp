<%--
  Created by IntelliJ IDEA.
  User: С�衮s ThinkPad
  Date: 2019/11/22
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    System.out.println("hello jsp");
    String contextPath = request.getContextPath();
    out.print(contextPath);
%>

<%!
    int i = 5;
%>

<%=
    i
%>
</body>
</html>
