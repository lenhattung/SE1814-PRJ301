<%-- 
    Document   : newjsp
    Created on : Mar 3, 2025, 5:20:02 AM
    Author     : tungi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- Trang source.jsp --%>
<html>
    <body>
        <h1>Trang Source</h1>

        <%-- Sử dụng jsp:forward để chuyển hướng đến trang destination.jsp --%>
        <jsp:forward page="destination.jsp">
            <jsp:param name="username" value="nguyenvan" />
            <jsp:param name="role" value="admin" />
            <jsp:param name="department" value="IT" />
        </jsp:forward>

        <%-- Nội dung này sẽ không được hiển thị --%>
        <p>Nội dung này sẽ không được hiển thị vì điều khiển đã được chuyển đến trang khác.</p>
    </body>
</html>
