<%-- 
    Document   : login
    Created on : Nov 22, 2019, 5:28:53 PM
    Author     : hams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="dashboard" method="POST">
            <label>Email</label>
            <input type="text" name="email"> <br>
            <label>Password</label>
            <input type="password" name="password"><br>
            <button type="submit">login</button>
        </form>
    </body>
</html>
