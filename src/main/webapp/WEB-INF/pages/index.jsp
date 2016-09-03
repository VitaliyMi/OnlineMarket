<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Market</title>
</head>
<body>
<div class="container">
    <h3>Hello, please introduce yourself!</h3>
    <h4>Are you ${client.name} again</h4>
    <form:form action="/showMenu" modelAttribute="client" method="post">

        Hi, my name is:<br>
        <form:input type="text" path="name" placeholder="Your name"/><br><br>
        <input type="submit" value="Go to menu">
    </form:form>

</div>
</body>
</html>