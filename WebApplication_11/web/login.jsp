<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div style="min-height: 800px">
            <form action="MainController" method="POST">
                <input type="hidden" name="action" value="login"/>
                User ID: <input type="text" name="strUserID" /> <br/>
                Password: <input type="password" name="strPassword" /> <br/>
                <input type="submit" value="Login" />
            </form>
            <%
                String message = request.getAttribute("message")+"";
            %>
            
            <%=message.equals("null")?"":message%>
            
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
