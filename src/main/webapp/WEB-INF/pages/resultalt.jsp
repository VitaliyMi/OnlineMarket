<%@ page import="application.model.Order" %>
<%@ page import="application.model.Dish" %>
<%@ page import="application.services.DefaultMenuService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
<%@ page import="application.model.OrderProcessingResultDTO" %>
  Created by IntelliJ IDEA.
  User: MSI
  Date: 20.07.2016
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Market</title>
</head>
<body>
<div class="container">
    <h3>Your order has been processed</h3>


    <table>
        <th>User</th><>
        <tr>
            <c:forEach var = "order" items="${totalOrdersDTO.orderList}">
                <td>${order.client.name}</td>
                <c:set var="">

            </c:forEach>
        </tr>
    </table>
    <input type="submit" value="View cart">
</div>
</body>
</html>