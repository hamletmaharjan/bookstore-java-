<%-- 
    Document   : index
    Created on : Nov 26, 2019, 6:57:39 PM
    Author     : hams
--%>
<%@page import="java.util.List"%>
<%@page import="edu.kist_bit.bookstore.entity.TableBook"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookStore</title>
    </head>
    <body>
        <label> User Type :</label>
        <form method ="post" action="dashboard">
            <input type="radio" name="usertype" value="admin">Administrator
            <input type="radio" name="usertype" value="customer">Customer<br>
            <button type="submit">ok</button>
        </form>
    </body>
</html>

