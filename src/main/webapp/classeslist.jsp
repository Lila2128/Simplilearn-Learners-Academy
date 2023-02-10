<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import ="DAO.*" %>
    <%@ page import = "pojo.*" %>
    <%@ page import = "java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLASS LIST</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a href="#" class="navbar-brand">Learners Academy</a>
        <ul class="navbar-nav">
            <li class="nav-item nav-link active">
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

<%
ClassDAO dao= new ClassDAO();
List<ClassName> list=dao.getallclasses();
%> 

<div class="container">
<br>
	<div class="btn btn-warning"><a href="classnew.jsp">Update Class</a></div>
</div>

<br>
<br>
<div class="container">
<table border="1">
<tr><th>ID</th><th>Class Name</th><th>Action</th></tr>
<%for(ClassName cn:list){ %>
<tr><td><%=cn.getCid() %></td>
<td><%=cn.getClassname() %></td>
<td><a href="cdelete.jsp?cid=<%=cn.getCid()%>">Delete</a></td>
<td><a href="SubjectsTeachers.jsp?classname=<%=cn.getClassname() %>">Subjects and Teachers</a></td>
<td><a href="classReport.jsp?classname=<%=cn.getClassname() %>">Class Report</a></td>
<%} %>
</table>
</div>

</body>
</html>