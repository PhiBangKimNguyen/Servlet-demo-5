<%-- 
    Document   : login
    Created on : 09-Oct-2022, 7:03:28 PM
    Author     : Phi N
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login" >
            <label>Username: </label>
            <input type="text"  name="username" value="${username}">
            <br>
            <label>Password: </label>
            <input type="password"  name="password" value="${password}">
            <br>
            <input type="submit" value="Login">
        </form>
        <p>${message}</p>
    </body>

</html>
