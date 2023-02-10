package classAdd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClassDAO;
import pojo.ClassName;

/**
 * Servlet implementation class ClassServlet
 */
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassServlet() {
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
		PrintWriter pw=response.getWriter();
		
		ClassName cn= new ClassName();
		cn.setCid(request.getParameter("cid"));
		cn.setCName(request.getParameter("cName"));
		ClassDAO dao = new ClassDAO();

		try {
			int row= dao.insertClassName(cn);
			if(row>0) {
				response.sendRedirect("classeslist.jsp");
				pw.println("Class added Successfully");
//				response.sendRedirect("classeslist.jsp");
			}else {
				pw.println("<h3>failed to add </h3>");
				RequestDispatcher rd= request.getRequestDispatcher("classnew.jsp");
				rd.include(request, response);
//				response.sendRedirect("classnew.html");
				
			}
		}catch(ClassNotFoundException | SQLException e ) {
				e.printStackTrace();
		}
	}

}
