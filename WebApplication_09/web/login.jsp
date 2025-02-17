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
        </div>
        <%@include file="footer.jsp" %>
       
        <!--
        The main difference between <jsp:include> and <%@ include %> lies in their processing time and behavior. The <%@ include %> directive is processed at translation time (when JSP is compiled into Servlet), acting like a copy-paste mechanism where the included file's content is directly merged into the main file, allowing shared variables between files but requiring recompilation if the included file changes. In contrast, <jsp:include> is processed at runtime, creating separate servlet instances where the included file's output is dynamically inserted into the main page, maintaining variable independence between files and allowing included files to be modified without recompiling the main page. For example, <%@ include file="header.jsp" %> would share variables with the main page and be more efficient but less flexible, while <jsp:include page="header.jsp" /> would keep variables separate and be more dynamic but slightly less performant.
        -->
            </body>
        </html>
