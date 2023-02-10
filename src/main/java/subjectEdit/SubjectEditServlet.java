package subjectEdit;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SubjectsDAO;
import pojo.Subjects;

/**
 * Servlet implementation class SubjectEditServlet
 */
public class SubjectEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectEditServlet() {
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
		System.out.println("Started Subject edit Servlet");
		Subjects sub = new Subjects();
		sub.setSubid(request.getParameter("subid"));
		sub.setClassname(request.getParameter("classname"));
		sub.setSubjects(request.getParameter("subjects"));
		SubjectsDAO dao = new SubjectsDAO();
		
		int row;
		try {
			try {
				row = dao.updateSubjects(sub);
				if(row>0) {
					response.sendRedirect("subjectlist.jsp");
				}
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				row = dao.insertSubjects(sub);
				if(row>0) {
					response.sendRedirect("subjectlist.jsp");
				}
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}finally {
			System.out.println("Executed Subject edit servlet");
		}
			
	} 

}
