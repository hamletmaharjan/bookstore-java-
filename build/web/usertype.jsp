<%-- 
    Document   : usertype
    Created on : Nov 29, 2019, 8:57:57 PM
    Author     : hams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookStore</title>
    </head>
    <body>
        <label> User Type :</label>
        <form method ="post" action="dec">
            <input type="radio" name="gender" value="male">Administrator
            <input type="radio" name="gender" value="female">Customer<br>
            <button type="button">ok</button>
        </form>
    </body>
</html>
