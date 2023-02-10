<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="DAO.SubjectTeachersDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Subject Teachers</title>
</head>
<body>

<!-- Here Unique id is passed from the list when the record containing delete button is clicked. 
Which is further passed to the DAO delete method
Later the page is redirected to the list page along with some attributes which are required to show class related sql list -->

	<%
		String id=request.getParameter("subtId");
		String Class=request.getParameter("classname");
		SubjectTeachersDAO.deleteSubjectTeachers(id);
		request.setAttribute("classname", request.getParameter("classname"));
		out.println(request.getParameter("classname"));
		request.getRequestDispatcher("SubjectsTeachers.jsp").forward(request, response);
		%>
</body>
</html>