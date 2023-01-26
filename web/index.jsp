<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="CSS/LoginStyle.css">
</head>
<body>
	<div class="loginContainer">
        <h3>Login Here</h3>
        <span style="color: red; text-align: center; font-weight: bold;">${error}</span>
        <form action='Login' method='post' id="LoginInput">
            <p>Username</p>
            <input type='text' name='username' placeholder='Enter username' required>
            <!--<span style="color: red; text-align: center; font-weight: bold;">${Username_error}</span>-->
            <p>Password</p>
            <span style="color: red; text-align: center; font-weight: bold; margin-bottom:5px;">${Password_error}</span>
            <input type='password' name='password' placeholder='Enter Password' required>
            <input type='submit' value="Login">
            <a href="JSP/SignUpIndex.jsp">Don't have an account?</a>
            <a href="JSP/ForgotIndex.jsp">Forgot Password</a>
            
        </form>
    </div>
</body>
</html>