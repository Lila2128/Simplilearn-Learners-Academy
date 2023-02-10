<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="pojo.*" %>
    <%@ page import="DAO.*" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Report</title>
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
            <li class="nav-item">
                <a href="teacherlist.jsp" class="nav-link">Teachers</a>
            </li>
            <li class="nav-item">
                <a href="LogoutServlet" class="nav-link">Logout</a>
            </li>
        </ul>   
</nav>
    <br>
    
    <%
		String Class=request.getParameter("classname");
    	List<SubjectTeachers> subteachlist= SubjectTeachersDAO.getclassReport(Class);
    	List<Students> stlist= StudentDAO.getclassReport(Class);
	%>
	
									<!-- LIST OF SUBJECT TEACHERS OF CLASS -->
	<h5 align="center"> List of Subject Teachers of Class <%=request.getParameter("classname") %></h5>
  	<div class="container">
   	<br>
      	<table border="1">
    	<tr><th>ID</th><th>Class</th><th>Subjects</th><th>Teachers</th></tr>
    	<% for(SubjectTeachers list:subteachlist){ %>
    	<tr><td><%=list.getSubtId() %></td><td><%=list.getClassname() %></td><td><%=list.getSubject() %></td>
    	<td><%=list.getTeacher() %></td>
    	<%} %>
    	</table>
    </div>
    <br>
    
    								<!-- LIST OF STUDENTS OF CLASS -->
    <h5 align="center"> List of Students of <%=request.getParameter("classname") %></h5>
	<div class="container">
	<table border="1">
	<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>DOB</th><th>Address</th><th>Phone</th><th>Class</th></tr>
	<% for(Students sts:stlist) {%>
	<tr><td><%=sts.getStid() %></td><td><%=sts.getSfname() %></td><td><%=sts.getSlname() %></td><td><%=sts.getsDOB() %></td>
	<td><%=sts.getSaddress() %></td>
	<td><%=sts.getSphone() %></td><td><%=sts.getClassname() %></td></tr>
	<%} %>
	</table>
	</div>
	  	
</body>
</html>