<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="pojo.ClassName" %>
    <%@ page import="DAO.ClassDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Class</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a href="#" class="navbar-brand">Learners Academy</a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="classeslist.jsp" class="nav-link">classes</a>
            </li>
            <li class="nav-item">
                <a href="studlist.jsp" class="nav-link">Students</a>
            </li>

            <li class="nav-item">
                <a href="subjectlist.jsp" class="nav-link">Subjects</a>
            </li>

            <li class="nav-item">
                <a href="teacherlist.jsp" class="nav-link">Teachers</a>
            </li>
            
            <li class="nav-item">
                <a href="LogoutServlet" class="nav-link">Logout</a>
            </li>
        </ul>
    </nav>
    
	<div class= "container">
	<form action="classEditServlet" method="post" >
	<br>
	<table>
	<tr><td>Class ID: </td><td>
	<input type="text" name="cid">
	</td></tr>
	<tr><td>Class Name: </td><td>
	<input type="text" name="classname">
	</td></tr>
	<tr><td>
	<input type="submit" value="Add"></td></tr>
	</table>
	</form>
</div>

</body>
</html>