<%--
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
    </select>

      <table>
        <th colspan="2">Dish</th><th>Price</th><th>Quantity</th>>
        <tr>
          <c:forEach var="order" items ="${orders}">
        <tr><td> <c:out value="${order.client.name}"/></td>
        <c:forEach var="dishes" items ="${order.orders}">
        <td>Dish: ${dishes.key.name}, quantity: ${dishes.value}</td>
        </c:forEach>
        </c:forEach>
      </table>



      <input type="submit" value="View cart">

  </div>
  </body>
  </html>