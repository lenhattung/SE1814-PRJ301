<%-- 
    Document   : invalid
    Created on : Feb 13, 2025, 8:50:09 AM
    Author     : tungi
--%>

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
            <h1>
                <font color="red">
                Invalid username or password!!!
                </font>
            </h1>
            <a href="login.jsp">Click here to try again</a>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
