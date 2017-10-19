<%-- 
    Document   : sendorderspage
    Created on : 16-10-2017, 15:01:57
    Author     : Bruger
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Orders</h1>
        <% User user = (User) request.getSession().getAttribute("user"); %>
        <% ArrayList arr = (ArrayList) request.getSession().getAttribute("oldorders"); %>
        <% String s = ""; %>
        <% for (int i = 0; i < arr.size(); i = i+6) {
            Order order = new Order(Integer.parseInt(arr.get(i).toString()), Integer.parseInt(arr.get(i+1).toString()), Integer.parseInt(arr.get(i+2).toString()),
            Integer.parseInt(arr.get(i+3).toString()), Integer.parseInt(arr.get(i+4).toString()), arr.get(i+5).toString());
            s = s + order.toString();
        }%>
        <%= s%>
        <br>
        <form name="sendorders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="sendorders">
            <input type="hidden" name="complete" value="yes">
            <input type="number" name="orderid" min=1 max=<%=arr.size()%>> Order id<br>
            <input type="radio" name="sent" value="Yes" checked > Send<br>
            <input type="radio" name="sent" value="No"> Unsend<br>
            <input type="submit" value="Submit">
        </form>
        <br>
        <% String success = (String) request.getSession().getAttribute("success");
            if (success.equalsIgnoreCase("yes")) {%>
            <H2>Success, the order have been updated</H2>
            <% }
            %>
        <br>
        <form name="login" action="FrontController" method="POST">
            <input type="hidden" name="command" value="login">
            Back to user:<br>
            <input type="hidden" name="email" value=<%=user.getEmail()%>>
            <input type="hidden" name="password" value=<%=user.getPassword()%>>
            <br>
            <input type="submit" value="Back">
        </form>
    </body>
</html>
