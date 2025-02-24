<%-- 
    Document   : user
    Created on : Feb 13, 2025, 8:49:59 AM
    Author     : tungi
--%>

<%@page import="dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div style="min-height: 800px">
            <%                if (session.getAttribute("user") != null) {
                    UserDTO user = (UserDTO) session.getAttribute("user");
            %>
            <h1>Welcome <%=user.getFullName()%> </h1>
            <form action="MainController" method="get">
                <input type="hidden" name="action" value="logout"/>
                <input type="submit" value="Logout"/>
            </form>

            <%
                String searchTerm = request.getAttribute("searchTerm") + "";
                searchTerm = searchTerm.equals("null") ? "" : searchTerm;
            %>
            <form action="MainController" method="get">
                <input type="hidden" name="action" value="search"/>
                Search books: <input type="text" name="searchTerm" value="<%=searchTerm%>"/>
                <input type="submit" value="Search"/>
            </form>

            <%
                if (request.getAttribute("books") != null) {
                    List<BookDTO> listBooks = (List<BookDTO>) request.getAttribute("books");
            %>    
            <table border="1">
                <tr>
                    <td>BookID</td>
                    <td>Title</td>
                    <td>Author</td>
                    <td>PublishYear</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Action</td>
                </tr>
                <%
                    for (BookDTO bdto : listBooks) {
                %>
                <tr>
                    <td><%=bdto.getBookID()%></td>
                    <td><%=bdto.getTitle()%></td>
                    <td><%=bdto.getAuthor()%></td>
                    <td><%=bdto.getPublishYear()%></td>
                    <td><%=bdto.getPrice()%></td>
                    <td><%=bdto.getQuantity()%></td>
                    <td><a href="MainController?action=delete&id=<%=bdto.getBookID()%>&searchTerm=<%=searchTerm%>"><img src="assets/images/delete-icon.png" 
                                style="height: 25px"/></a></td>
                </tr>
                <%
                    }
                %>
            </table>    
            <%    }
            %>


            <%} else {%>
            You do not have permission to access this content.
            <%}%>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
