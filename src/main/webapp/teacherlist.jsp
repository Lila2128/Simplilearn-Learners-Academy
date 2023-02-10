<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="DAO.TeacherDAO" %>
    <%@ page import = "pojo.Teachers" %>
    <%@ page import = "java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a href="#" class="navbar-brand">Learners Academy</a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="classeslist.jsp" class="nav-link">Classes</a>
            </li>
            <li class="nav-item">
                <a href="studlist.jsp" class="nav-link">Students</a>
            </li>

            <li class="nav-item">
                <a href="subjectlist.jsp" class="nav-link">Subjects</a>
            </li>

            <li class="nav-item nav-link active">
                <a href="teacherlist.jsp" class="nav-link">Teachers</a>
            </li>
            
            <li class="nav-item">
                <a href="LogoutServlet" class="nav-link">Logout</a>
            </li>
        </ul>
    </nav>
    <br>


    <%
	TeacherDAO dao= new TeacherDAO();
	List<Teachers> list =dao.getallteachers();
	%> 

<!--  Form to add Teachers -->
<div class= "container">
	<form action="TeacherEditServlet" method="post">
	Teacher Id: <input type="text" name="tid"><br><br>
	First Name: <input type="text" name="fname"><br><br>
	Last Name: <input type="text" name="lname"><br><br>
	DOB: <input type="date" name="DOB"><br><br>
	Address: <input type="text" name="address"><br><br>
	Phone: <input type="text" name="phone"><br><br>
	Designation: <input type="text" name="designation">  
	<input type="submit" value="Update">
	</form>
	<br>
</div>

<h3 align="center"> List of Teachers</h3>

<!-- List showing All the Teachers -->
<div class="container">

<table border="1">
<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>DOB</th><th>Address</th><th>Phone</th><th>Designation</th><th>Action</th></tr>
<%for(Teachers t:list){ %>
<tr><td><%=t.getTid() %> </td><td><%=t.getFname() %></td><td><%=t.getLname() %></td><td><%=t.getDOB() %>   </td>
<td><%=t.getAddress() %></td><td><%=t.getPhone()%></td><td><%=t.getDesignation() %></td>
<td><a href="tdelete.jsp?tid=<%=t.getTid()%>">Delete </a></td>
</tr>
<%} %>
</table>
</div>
    
</body>
</html>