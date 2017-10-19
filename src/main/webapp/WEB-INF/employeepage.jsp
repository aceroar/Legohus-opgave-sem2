<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>

        <h1>Hello <%=request.getParameter("email")%> </h1>
        <br>
        <h2>View old orders</h2>
        <form name ="oldorders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="oldorders">
            <input type="hidden" name="user" value=<%=request.getSession().getAttribute("user")%>>
            <input type="submit" value="View Old Orders">
        </form>
            <br>
        <h2>Send/Unsend Orders</h2>
        <form name ="sendorders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="sendorders">
            <input type="hidden" name="user" value=<%=request.getSession().getAttribute("user")%>>
            <input type="hidden" name="complete" value="no">
            <input type="submit" value="Send/Unsend Orders">
        </form>
    </body>
</html>
