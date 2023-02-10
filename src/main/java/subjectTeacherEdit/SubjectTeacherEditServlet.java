package subjectTeacherEdit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.SubjectTeachersDAO;
import pojo.SubjectTeachers;

/**
 * Servlet implementation class SubjectTeacherEditServlet
 */
public class SubjectTeacherEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectTeacherEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Started Subject and Teacher edit Servlet");
		PrintWriter out = response.getWriter();
		SubjectTeachers subteach = new SubjectTeachers();
		subteach.setClassname(request.getParameter("classname"));
		subteach.setSubject(request.getParameter("subject"));
		subteach.setTeacher(request.getParameter("teacher"));
		SubjectTeachersDAO dao = new SubjectTeachersDAO();
		int row;
			try {
				row = dao.insertSubjectTeachers(subteach);
				if(row>0) {
					//here to return the same classname after deleting record we are passing the attribute value to the parameter and forwarding it 
					//along with the page .
					request.setAttribute("classname", request.getParameter("classname"));
					request.getRequestDispatcher("SubjectsTeachers.jsp").forward(request, response);
				}
				else {
					out.println("<html><body><br><h4> Insertion Failed </h4></body></html>");
				}
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Executed SubjectTeachers edit servlet");
	} 
}

