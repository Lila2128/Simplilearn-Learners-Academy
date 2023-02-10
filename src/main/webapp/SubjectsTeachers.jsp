<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="pojo.*" %>
    <%@ page import="DAO.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects and Teachers</title>

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
    TeacherDAO tdao=new TeacherDAO();
    SubjectsDAO subdao=new SubjectsDAO();
    List<Teachers> tlist= tdao.getallteachers();
    List<Subjects> sublist= subdao.getallsubjects();
    %>
    
    <%
		String Class=request.getParameter("classname");
		List<SubjectTeachers> subteachlist=SubjectTeachersDAO.getclassReport(Class);
		%>
    
    <h5 align="center">Add Subjects and Teachers to <%=request.getParameter("classname") %></h5>
    <div class="container">
    
    <!-- List to show the add Subject Teachers to the list -->
    <form action="SubjectTeacherEditServlet" method="post">
    
    <input type="hidden" name="classname" value="<%=request.getParameter("classname") %>">
    	Select Subject <select name="subject">
    	<option>Select an option
    	<%for(Subjects sub:sublist) {%>
    	<option><%=sub.getSubjects()%>
    	<%} %>
    	</select>
    	<br><br>
    	Select Teacher <select name="teacher">
    	<option>Select an option
    	<%for(Teachers t:tlist) {%>
    	<option><%=t.getFname() %> <%=t.getLname() %>
    	<%} %>
    	</select>
    	<br>
    	<br>
    	<input type="submit" value="Add">
    </form>
    </div>

<!-- List of Subject Teachers of respective Class when clicked from the Class List -->
 <h5 align="center"> List of Subject Teachers</h5>
  <div class="container">
   <br>
      	<table border="1">
    	<tr><th>ID</th><th>Class</th><th>Subjects</th><th>Teachers</th><th>Action</th></tr>
    	<% for(SubjectTeachers list:subteachlist){ %>
    	<tr><td><%=list.getSubtId() %></td><td><%=list.getClassname() %></td><td><%=list.getSubject() %></td><td><%=list.getTeacher() %></td>
    	<td><a href="subjectsTeacherdelete.jsp?subtId=<%=list.getSubtId() %>&classname=<%=list.getClassname() %>">Delete Subject Teacher</a></td></tr>
    	<%} %>
    	</table>
    </div>
</body>
</html>