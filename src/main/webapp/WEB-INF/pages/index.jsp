<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Market</title>
</head>
<body>
<div class="container">
    <h3>Hello, please introduce yourself!</h3>
    <h4>Are you ${client.name} again</h4>
    <form action="/addClient" method="post">

        Hi, my name is:<br>
        <input type="text" name="name" value="Name" required><br><br>
        <input type="submit" value="Go to menu">
    </form>

</div>
</body>
</html>