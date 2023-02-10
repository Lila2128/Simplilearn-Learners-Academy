<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="DAO.*" %>
    <%@ page import="pojo.*" %>
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
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
            <li class="nav-item nav-link active">
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
 StudentDAO dao= new StudentDAO();
 List<Students> list= dao.getallstudents();
 ClassDAO cdao= new ClassDAO();
 List<ClassName> clist= cdao.getallclasses();
 %>
 
 				<!-- Form to fill in Student Details  -->
 <div class="container">
    <form action="StudentEditServlet" method="post">
    	ID <input type="text" name="stid"><br><br>
    	First Name <input type="text" name="sfname"><br><br>
    	Last Name <input type="text" name="slname"><br><br>
    	DOB <input type="date" name="sDOB"><br><br>
    	Address <input type="text" name="saddress"><br><br>
    	Phone <input type="text" name="sphone"><br><br>
    	Select class <select name="classname">
    	<option>Select an Option
    	<%for(ClassName cn:clist){ %>
    	<option><%=cn.getClassname() %>
 		<%} %>
    	</select>
    	<br>
    	<input type="submit" value="Update">
    </form>
    </div>
 
 							<!--  List of Students -->
  <h5 align="center"> List of Students </h5>
<div class="container">
<table border="1">
<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>DOB</th><th>Address</th><th>Phone</th><th>Class</th><th>Action</th></tr>
<% for(Students st:list) {%>
<tr><td><%=st.getStid()%></td><td><%=st.getSfname() %></td><td><%=st.getSlname() %></td><td><%=st.getsDOB()%></td><td><%=st.getSaddress() %></td>
<td><%=st.getSphone() %></td><td><%=st.getClassname() %></td><td><a href="studdelete.jsp?stid=<%=st.getStid()%>">Delete Student</a></td></tr>
<%} %>
</table>
</div>

</body>
</html>