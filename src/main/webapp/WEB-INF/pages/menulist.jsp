<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Market</title>
</head>
<body>

<div class="container">
    <h3>Here you will find our menu</h3>
    <form action="/showMenu">
    Sort by
        <select name =  "sorter">
        <option value = description> Description</option>
        <option value = price> Price</option><br>
        <input type="submit" value="Sort">
        </select>
    </form>>


    <form action="/viewCart">
        <table>
            <th colspan="2">Dish</th><th>Price</th>
            <c:forEach var="dish" items ="${menuList}">
                <tr><td> <c:out value="${dish.name}"/></td>
                    <td><img src="<c:out value="${dish.url}"/>"height="200", width="250"></td>
                    <td><c:out value="${dish.price}"/></td>
                    <td><input type="number" name="numberof<c:out value="${dish.name}"/>" min =1 max =30></td>
                    <td><input type="checkbox" name="selected" value="<c:out value="${dish.name}"/>" min =1 max =30></td></tr>
            </c:forEach>
        </table>



        <input type="submit" value="View cart">
    </form>

</div>
</body>
</html>

