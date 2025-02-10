<%-- 
    Document   : output
    Created on : Feb 10, 2025, 8:54:49 AM
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
        <%
            int n = (int)request.getAttribute("n");
        %>
        <h3>BẢNG CỬU CHƯƠNG <%=n%></h3>
        <%
            for(int i=1; i<=10; i++){
        %>
            <%=n%> * <%=i%> = <%=(i*n)%><br/>
        <%
            }
        %>
    </body>
</html>
