<%-- 
    Document   : oldordrerpage
    Created on : 11-10-2017, 14:36:58
    Author     : Bruger
REMOVE OUT.PRINT!!!!!
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="FunctionLayer.BillOfMaterials"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
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
        <% BillOfMaterials bom = new BillOfMaterials(); %>
        <% ArrayList arr = (ArrayList) request.getSession().getAttribute("oldorders"); %>
        <% String o = ""; %>
        <% String b = ""; %>
        <% String s = ""; %>
        <% List st = new ArrayList(); %>
        <% List so = new ArrayList(); %>
        <% List sb = new ArrayList(); %>
        <% for (int i = 0; i < arr.size(); i = i+6) {
            Order order = new Order(Integer.parseInt(arr.get(i).toString()), Integer.parseInt(arr.get(i+1).toString()), Integer.parseInt(arr.get(i+2).toString()),
            Integer.parseInt(arr.get(i+3).toString()), Integer.parseInt(arr.get(i+4).toString()), arr.get(i+5).toString());
            o = o + order.toString();
            so = Arrays.asList(o.split("<br />"));
            b = b + bom.toString(order);
            sb = Arrays.asList(b.split("<br />"));
        }%>
        <% for(int i = 0; i < so.size() ; i++) {
            st.add(so.get(i));
            st.add(sb.get(i));
        }%>
        <% for(int i = 0; i < st.size() ; i++) {
            s += st.get(i) + "<br />";
        }%>
        <%= s%>
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
