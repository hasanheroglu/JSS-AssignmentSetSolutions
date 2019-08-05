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
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(window).on('load', function () {
            $("#username-exists").hide();
            $("#username-error").hide();
            $("#password-error").hide();
            $("#password-match-error").hide();
            $("#password-conf-error").hide();
            $("#email-error").hide();
        });

        $(document).ready ( function () {
            $(document).on ("click", "#submit", function () {
                $("#username-exists").hide();
                $("#username-error").hide();
                $("#password-error").hide();
                $("#password-match-error").hide();
                $("#password-conf-error").hide();
                $("#email-error").hide();

                var errorExist = false;

                $.post("check_uniqueness", {username: $("#username").val()}, function (responseText) {
                    if(responseText == "yes"){
                        $("#username-exists").show();
                        errorExist = true;
                    }
                    errorExist = true;
                });

                if($("#username").val() == "" ){
                    $("#username-error").show();
                    errorExist = true;
                }
                if($("#password").val() == "" ){
                    $("#password-error").show();
                    errorExist = true;
                } else if($("#password").val() != $("#password-conf").val()){
                    $("#password-match-error").show();
                    errorExist = true;
                }

                if($("#password-conf").val() == "" ){
                    $("#password-conf-error").show();
                    errorExist = true;
                }
                if($("#email").val() == "" ){
                    $("#email-error").show();
                    errorExist = true;
                }

                return !errorExist;
            });
        });
    </script>
</head>
<body>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
    <form:form action="register" id="registerForm" modelAttribute="user" method="post" style="text-align: left">
        <div class="form-group">
            <label for="username">Username: </label>
            <form:input type="text" class="form-control" id="username" path="username" value="hasan" />
            <p id="username-error" style="color:darkred">Username is null!</p>
            <p id="username-exists" style="color:darkred">Username exists!</p>
        </div>


        <div class="form-group">
            <label for="email">Email: </label>
            <form:input type="text" class="form-control" id="email" path="email" value="" />
            <p id="email-error" style="color:darkred">Email is null!</p>
        </div>

        <label for="birthday">Birthday: </label>
        <div class="form-group" id="birthday">
            <form:input type="date" class="form-control" id="birthday" path="birthday"></form:input>
        </div>
        <div class="form-group">
            <label for="gender">Sex: </label><br>
            <div id="gender" class="custom-control custom-radio custom-control-inline">
                <form:radiobutton id="gender_0" path="sex" value="0" checked="true" class="custom-control-input" />
                <label class="custom-control-label" for="gender_0">Female</label>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
                <form:radiobutton id="gender_1" path="sex" value="1" class="custom-control-input" />
                <label class="custom-control-label" for="gender_1">Male</label>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
                <form:radiobutton id="gender_2" path="sex" value="2" class="custom-control-input" />
                <label class="custom-control-label" for="gender_2">Other</label>
            </div>
        </div>

        <div class="form-group">
            <label for="password">Password: </label>
            <form:password class="form-control" id="password" path="password" value="" />
            <p id="password-error" style="color:darkred">Password is null!</p>
            <p id="password-match-error" style="color:darkred">Passwords do not match!</p>
        </div>

        <div class="form-group">
            <label for="password-conf">Password Confirmation: </label>
            <input type="password" class="form-control" id="password-conf" name="password_conf" value="">
            <p id="password-conf-error" style="color:darkred">Password confirmation is null!</p>
        </div>
        <input class="btn btn-primary btn-block" id="submit" type="submit" value="Register">
    </form:form>



</div>
</body>
</html>