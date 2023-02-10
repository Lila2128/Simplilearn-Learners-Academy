<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Add Subjects and Teachers to BSc CS</h3>
<br><br>
<form action="SubjectTeachersAddServlet" method="get">
Select Subject <select name="subject">
<option value="Select an option"> Select an option</option>
<option value="DataStructures">DataStructures</option>
<option value="C">C</option>
<option value="Linux">Linux</option>
</select>
<br><br> 
Select Teachers <select name="subject">
<option value="Select an option"> Select an option</option>
<option value="Vikram">Vikram</option>
<option value="Sahil">Sahil</option>
<option value="Lakhmi">Lakhmi</option>
</select>
</form>

</body>
</html>