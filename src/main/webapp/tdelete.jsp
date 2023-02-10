<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="DAO.TeacherDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Teacher</title>
</head>
<body>

<!-- Here Unique id is passed from the list when the record containing delete button is clicked. 
Which is further passed to the DAO delete method
Later the page is redirected to the list page  -->

<%
		String id=request.getParameter("tid");
		TeacherDAO.deleteTeacher(id);
		response.sendRedirect("teacherlist.jsp");
		%>
</body>
</html>