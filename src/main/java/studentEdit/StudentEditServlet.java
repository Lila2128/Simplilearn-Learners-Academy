package studentEdit;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import pojo.Students;

/**
 * Servlet implementation class StudentEditServlet
 */
public class StudentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditServlet() {
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
		System.out.println("entered student Edit Servlet");
		Students st=new Students();
		
		String dateString = request.getParameter("sDOB");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");//Convertion of String date to date Util date format to pass through setters and getters
		Date submitDate= null;
		try {
			submitDate = sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st.setsDOB(submitDate);
		
		st.setStid(request.getParameter("stid"));
		st.setSfname(request.getParameter("sfname"));
		st.setSlname(request.getParameter("slname"));
		st.setSaddress(request.getParameter("saddress"));
		st.setSphone(request.getParameter("sphone"));
		st.setClassname(request.getParameter("classname"));
		
		StudentDAO dao= new StudentDAO();
		int row;
		try {
			try {
				row = dao.updateStudent(st);
				if(row>0) {
					response.sendRedirect("studlist.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				row = dao.insertStudent(st);
				if(row>0) {
					response.sendRedirect("studlist.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}finally {
			System.out.println("Student Edit Servlet executed");
		}
	}

}
