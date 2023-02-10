<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<h1>Welcome to Learners Academy</h1>

             <!-- Welcome Page : enter the username and password same there is no database for it-->
<form action="LoginServlet" method="post">
<h6>Please enter the username and password same</h6>
UserName<br>
<input type="text" name="user">
<br><br>
Password<br>
<input type="password" name="password">
<br><br>
<input type="submit" value="login">
<br>
</form>

</body>
</html>