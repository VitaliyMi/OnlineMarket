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
    <title></title>
</head>
<body>
  Did we get everything clear?
<form action="prosesOrder">
  <table>
    <c:forEach var="dish" items="${order.orders}">
     <tr>
       <td><c:out value="${dish.key.name}"/></td>
       <td><img src="<c:out value="${dish.key.url}"/>" height="200", width="250"> </td>
       <td><c:out value="${dish.value}"/> </td>
       <td><c:out value="${dish.key.price*dish.value}"/>  </td>
     </tr>
    </c:forEach>
  </table>
    <input type="submit" value = "Prosess order"/>

    </form>

</body>
</html>
