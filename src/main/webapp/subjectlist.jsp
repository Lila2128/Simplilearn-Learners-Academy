<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="pojo.*" %>
    <%@ page import="DAO.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject List</title>
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

            <li class="nav-item nav-link active">
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
    SubjectsDAO dao =new SubjectsDAO();
    List<Subjects> list = dao.getallsubjects(); 
    ClassDAO cdao=new ClassDAO();
    List<ClassName> clist= cdao.getallclasses();
    %>
    
    <!-- Subject List Edit Form -->
<div class="container">
<form action="SubjectEditServlet" method="post">

Subject Id: <input name="subid" type="text">
<br><br>
Class:
<select name="classname" >
<option> Select Class</option>
<%for(ClassName cn: clist){ %>
<option><%=cn.getClassname() %>
<%} %>
</select>
<br><br>
Subjects:
<input name="subjects" type="text">
<br><br>
<input value="submit" type="submit">
</form>
</div>
    
    <!-- List of Subjects -->
    <div class="container">
    	<h4 align="center"> List of Subjects </h4>
    	
    	<table border="1">
    	<tr><th>ID</th><th>Class</th><th>Subjects</th><th>Action</th></tr>
    	<% for(Subjects sub:list){ %>
    	<tr><td><%=sub.getSubid() %></td><td><%=sub.getClassname() %></td><td><%=sub.getSubjects() %></td>
    	<td><a href="subdelete.jsp?subid=<%=sub.getSubid() %>">Delete Subject</a></td></tr>
    	<%} %>
    	</table>
    </div>
    
    
</body>
</html>