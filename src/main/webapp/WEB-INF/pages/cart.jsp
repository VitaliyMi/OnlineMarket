<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 01.08.2016
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
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
<div class="page-header">
  <h3>Did we get everything clear?</h3>
  </div>
<div class="jumbotron">
  <table class="table table-bordered table-striped table-hover">
    <th class="text-center">Dish</th>
    <th class="text-center">Image</th>
    <th class="text-center">Quantity</th>
    <th class="text-center">Total price</th>
    <c:forEach var="dish" items="${order.dishes}">
     <tr>
       <td><c:out value="${dish.key.name}"/></td>
       <td><img src="<c:out value="${dish.key.url}"/>" height="200", width="250"> </td>
       <td><c:out value="${dish.value}"/> </td>
       <td>$ <c:out value="${dish.key.price*dish.value}"/>  </td>
     </tr>
    </c:forEach>
  </table>
  <div class="btn-group btn-group-lg">
    <form action="/processOrder">
      <button type="submit" class="btn btn-success " >Process order</button>
      <button type="submit" class="btn btn-warning" formaction="/showMenu">Show menu</button>
    </form>
  </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>
