<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Success</title>
</head>
<body>
    <h3>Hi <%= request.getAttribute("user") %>, Login successful.</h3>
    <a href="login.html">Logout</a>
</body>
</html>
