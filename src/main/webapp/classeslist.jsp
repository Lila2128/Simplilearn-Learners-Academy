<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "DAO.*"  %>
    <%@ page import = "pojo.*" %>
    <%@ page import = "java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a href="#" class="navbar-brand">Learners Academy</a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="#" class="nav-link">classes</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link">Students</a>
            </li>

            <li class="nav-item">
                <a href="#" class="nav-link">Subjects</a>
            </li>

            <li class="nav-item">
                <a href="#" class="nav-link">Teachers</a>
            </li>
            
            <li class="nav-item">
                <a href="#" class="nav-link">Logout</a>
            </li>
        </ul>
        
    </nav>

<%
ClassDAO dao= new ClassDAO();
List<ClassName> list =dao.getallclasses();
%> 
<a href="classnew.jsp">Add New Class</a>
<button onclick="alert(hello)">Add new Class</button>
<br>
<br>
<form action="" method="get">
<table border="1">
<tr><th>ID</th><th>Class Name</th><th>Action</th></tr>
<%for(ClassName cn:list){ %>
<tr><td><%=cn.getCid() %></td><td><%=cn.getCName() %></td><td><a href="cedit.jsp">Edit</a></td>
<td><a href="cdelete.jsp">Delete</a></td><td><%=cn.getCid() %><a href="SubjectsTeachers.jsp">Subjects and Teachers</a></td>
<td><a href="classReport.jsp">Class Report</a></td></tr>
<%} %>
</table>
</form>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>