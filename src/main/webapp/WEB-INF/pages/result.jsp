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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Online Market</title>
    <link rel="stylesheet"  type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  <div class="container">
    <div class="page-header">
      <h3>All orders</h3>
    </div>


    <table class="table table-bordered table-striped table-hover">
      <th class="text-center">User</th>
      <c:forEach var = "dishnames" items="${totalOrdersDTO.totalNumberOfEachDishOrdered}">
        <th  class="text-center">${dishnames.key}</th>
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
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
  </html>