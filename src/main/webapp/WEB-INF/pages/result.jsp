<%--
<%@ page import="application.model.OrderProcessingResultDTO" %>
  Created by IntelliJ IDEA.
  User: MSI
  Date: 20.07.2016
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
      <th>User</th>
      <c:forEach var = "dishnames" items="${totalOrdersDTO.totalNumberOfEachDishOrdered}">
        <th>${dishnames.key}</th>
      </c:forEach>
      <th></th>
      <tr>
        <c:forEach var = "order" items="${totalOrdersDTO.orderList}">
        <td>${order.client.name}</td>

          <c:forEach var = "dishnames" items="${totalOrdersDTO.totalNumberOfEachDishOrdered}">
            <c:set var="contains" value="false"/>
            <c:forEach var = "dish" items="${order.dishes}">
              <c:if test="${dishnames.key eq dish.key.name}">
                <c:set var="contains" value="true" />
                <c:set var ="value"  value="${dish.value}"/>
              </c:if>

            </c:forEach>
            <c:choose>
              <c:when test="${contains==true}" >
                <td>${value}</td>
              </c:when>
              <c:otherwise>
                <td>0</td>
              </c:otherwise>
            </c:choose>
          </c:forEach>
               <td>$${totalOrdersDTO.totalClientOrderPrice[order.client.name]}</td></tr>
      </c:forEach>
      <tr><td>Total:</td>

        <c:forEach var = "dishes" items="${totalOrdersDTO.totalNumberOfEachDishOrdered}">
               <td>${dishes.value}</td>
      </c:forEach>
      <td>${totalOrdersDTO.totalDishesOrdered} / $${totalOrdersDTO.totalSum}</td></tr>
    </table>
      <input type="submit" value="View cart">
  </div>
  </body>
  </html>