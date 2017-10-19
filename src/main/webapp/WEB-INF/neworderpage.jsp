<%-- 
    Document   : newordrerpage
    Created on : 11-10-2017, 14:36:42
    Author     : Bruger
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.BillOfMaterials"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>       
    </head>
    <body>       
        <h1>New Order</h1>
        <%User user = (User) request.getSession().getAttribute("user");%>
        <form name ="neworder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="neworder">
            <input type="hidden" name="complete" value="yes">
            Length:<br>
            <input type="number" name="length" min="4" max="999999">
            <br>
            Width:<br>
            <input type="number" name="width" min="4" max="999999">
            <br>
            Height:<br>
            <input type="number" name="height" min="2" max="999999">
            <br>
            <input type="hidden" name="userid" value= <%=user.getId()%>>
            <input type="submit" value="Submit">
        </form>
        <% String success = (String) request.getSession().getAttribute("success");
            if (success.equalsIgnoreCase("yes")) {%>
        <H2>Success, you order is confirmed</h2>
        <%BillOfMaterials BOM = new BillOfMaterials();%>
        <%=BOM.toString(new Order(0, Integer.parseInt(request.getParameter("length")),Integer.parseInt(request.getParameter("width")),
                Integer.parseInt(request.getParameter("height")), Integer.parseInt(request.getParameter("userid")), "No" ))%>
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
</body>
</html>
