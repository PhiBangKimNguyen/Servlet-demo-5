<%-- 
    Document   : home
    Created on : 09-Oct-2022, 7:03:28 PM
    Author     : Phi N
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home </h1>
        <p>Hello ${user.username}</p>
        <a href="login?logout" name="logout">Log out</a>
    </body>
    
</html>
