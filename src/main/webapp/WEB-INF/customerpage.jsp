<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%></h1>
        You are now logged in as a customer of our wonderful site.
        <br>
        <h2>Create new order</h2>
        <form name ="oldorders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="neworder">
            <input type="hidden" name="complete" value="no">
            <input type="submit" value="Create New Order">
        </form>
        <br>
        <h2>View old orders</h2>
        <form name ="oldorders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="oldorders">
            <input type="hidden" name="role" value=<%=request.getSession().getAttribute("role")%>>
            <input type="submit" value="View Old Orders">
        </form>
    </body>
</html>
