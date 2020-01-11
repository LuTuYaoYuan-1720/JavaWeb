<%@ page import="dao.BookDao" %>
<%@ page import="domain.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 小予‘s ThinkPad
  Date: 2019/12/22
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    BookDao dao = new BookDao();
    List<Book> allBook = dao.getAllBook();
    request.getSession().setAttribute("list", allBook);

    for (Book book : allBook) {
%>
<hr>
<P><label>书号:</label><%=book.getBookNumber()%>
</P>
<P><label>书名:</label><a href="/bookdetails.jsp?bookNum=<%=book.getBookNumber()%>"><%=book.getBookTitle()%></a>
</P>
<P><label>主编:</label><%=book.getEditor()%>
</P>
<P><label>价格:</label><%=book.getPrice()%>
</P>
<P><label>出版社:</label><%=book.getPublishingHouse()%>
</P>
<%
    }
%>
</body>
</html>
