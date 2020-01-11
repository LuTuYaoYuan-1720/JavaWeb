<%@ page import="dao.MessageDao" %>
<%@ page import="domain.Message" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 小予‘s ThinkPad
  Date: 2019/12/23
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有留言</title>
</head>
<body>
<%
    Object count = request.getSession().getAttribute("count");
    if (count == null) {
        request.getSession().setAttribute("count", 1);
    } else {
        request.getSession().setAttribute("count", (Integer) count + 1);
    }
%>
浏览量 : <font color="red">${count}</font><br>
<a href="${pageContext.request.contextPath}/addMessage.html">添加新的留言内容</a><br>
<%
    //若session中有已登录用户对象，就显示出所有留言
    if (request.getSession().getAttribute("msg") != null) {
        MessageDao dao = new MessageDao();
        List<Message> allMessage = dao.getAllMessage();
        for (Message message : allMessage) {
%>
<hr>
<p><label>姓名 : </label> <%=message.getName()%>
</p>
<p><label>电话 : </label> <%=message.getPhone()%>
</p>
<p><label>邮箱 : </label> <%=message.getEmail()%>
</p>
<p><label>标题 : </label> <%=message.getTitle()%>
</p>
<p><label>内容 : </label><br>
    <textarea rows="10" cols="50" contenteditable="false"><%=message.getContent()%></textarea></p>
<p><label>留言时间 : </label> <%=message.getTime()%>
</p>
<%
    }
} else {
%>
<a href="/login.html">登录</a><br>
<%
    }
%>

</body>
</html>
