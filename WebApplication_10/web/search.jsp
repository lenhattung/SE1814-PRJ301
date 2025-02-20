<%-- 
    Document   : user
    Created on : Feb 13, 2025, 8:49:59 AM
    Author     : tungi
--%>

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
            <%
                UserDTO user = (UserDTO) request.getAttribute("user");
            %>
            <h1>Welcome <%=user.getFullName()%> </h1>
            <form action="MainController" method="get">
                <input type="hidden" name="action" value="logout"/>
                <input type="submit" value="Logout"/>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
