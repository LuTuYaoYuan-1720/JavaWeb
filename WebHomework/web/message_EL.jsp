<jsp:useBean id="count" scope="session" type="java.lang.Integer"/>
<jsp:useBean id="messages" scope="session" type="java.util.List"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>所有留言</title>
</head>
<body>
浏览量:<font color="red">${count}</font>
<c:forEach var="message" items="${messages}" varStatus="statu">
    <hr>
    <p><label>姓名：</label>${message.getName()}</p>
    <p><label>手机号：</label>${message.getPhone()}</p>
    <p><label>邮箱：</label>${message.getEmail()}</p>
    <p><label>标题：</label>${message.getTitle()}</p>
    <p><label>内容：</label><br>
        <textarea rows="10" cols="50" contenteditable="false">${message.getContent()}</textarea>
    </p>
</c:forEach>
</body>
</html>
