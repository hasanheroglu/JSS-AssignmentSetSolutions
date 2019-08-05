<%--
  Created by IntelliJ IDEA.
  User: hasan
  Date: 2019-07-16
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="login" method="post" style="text-align: left">
        <div class="form-group">
            <label for="username">Username: </label>
            <input type="text" class="form-control" id="username" name="username" value="">
        </div>
        <div class="form-group">
            <label for="password">Password: </label>
            <input type="password" class="form-control" id="password" name="password" value="">
        </div>
        <input class="btn btn-primary btn-block" type="submit" value="Login">
    </form>
</div>
</body>
</html>
