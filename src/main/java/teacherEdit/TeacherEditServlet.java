package teacherEdit;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TeacherDAO;
import pojo.Teachers;

/**
 * Servlet implementation class TeacherEditServlet
 */
public class TeacherEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherEditServlet() {
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
		System.out.println("Entered Teacher Edit Servlet");
		Teachers t = new Teachers();
		
		//Following codes are required as setters and getters doesn't support any other datatypes than String.
				//To convert Date datatype to String datatype we assign to a String variable then to get a Util Date format we used a
//				SimpleDateFormat() method and parse the String value to a Date variable. And set the Util Date variable to the object.
				String dateString = request.getParameter("DOB");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				Date submitDate = null;
				try {
					submitDate = sdf.parse(dateString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.setDOB(submitDate);
				
				
				t.setFname(request.getParameter("fname"));
				t.setLname(request.getParameter("lname"));
				t.setTid(request.getParameter("tid"));
//				Here also the setter doesn't access the long datatype hence the following method is used. 
				t.setPhone(Long.decode(request.getParameter("phone")).longValue());
				t.setAddress(request.getParameter("address"));
				t.setDesignation(request.getParameter("designation"));
				
				TeacherDAO dao = new TeacherDAO();
				int row;
				try {
					try {
						row = dao.updateTeacher(t);
						if(row>0) {
							response.sendRedirect("teacherlist.jsp");
						}
					}catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try{
						row = dao.insertTeachers(t);
						if(row>0) {
							response.sendRedirect("teacherlist.jsp");
						}
					}catch(ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} finally {
					System.out.println("Executed Teacher Edit Servlet");
				}
	}

}
