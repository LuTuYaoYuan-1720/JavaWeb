<%@ page import="domain.Book" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: 小予‘s ThinkPad
  Date: 2019/12/22
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String bookNumber = request.getParameter("bookNum");

    Object list = request.getSession().getAttribute("list");
    ArrayList<Book> books = new ArrayList<>();
    if (list instanceof ArrayList<?>) {
        for (Object obj : (ArrayList<?>) list) {
            books.add((Book) obj);
        }
    }
    Book res = null;
    for (Book b : books) {
        if (b.getBookNumber().equals(bookNumber)) {
            res = b;
            break;
        }
    }


%>
<P><label>详细信息:</label><%=res.getDetail()%>
</P>
</body>
</html>
