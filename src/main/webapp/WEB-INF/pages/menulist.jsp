<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <h3>Here you will find our menu</h3>
    </div>
    <div class="jumbotron">
    <form action="/showMenu">
    Sort by
        <select name =  "sorter">
        <option value = description> Description</option>
        <option value = price> Price</option><br>
        <input type="submit" value="Sort">
        </select>
    </form>

    <p>${message}</p>

    <form action="/viewCart">
        <table class="table table-bordered table-striped table-hover">
            <th class="text-center">Dish</th>
            <th class="text-center">Image</th>
            <th class="text-center">Price</th>
            <th colspan="2" class="text-center">Select dishes</th>
            <c:forEach var="dish" items ="${menuList}">
                <tr><td> <c:out value="${dish.name}"/></td>
                    <td><img src="<c:out value="${dish.url}"/>"height="200", width="250"></td>
                    <td><c:out value="${dish.price}"/></td>
                    <td><input type="number" name="numberof<c:out value="${dish.name}"/>" min =1 max =30></td>
                    <td><input type="checkbox" name="selected" value="<c:out value="${dish.name}"/>" min =1 max =30></td></tr>
            </c:forEach>
        </table>

        <input type="submit" value="View cart" class="btn-primary btn-lg">
    </form>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

