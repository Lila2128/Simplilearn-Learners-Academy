package classEdit;

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
 * Servlet implementation class classEditServlet
 */
public class classEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classEditServlet() {
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
		System.out.println("Started Class edit Servlet");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		ClassName cn = new ClassName();
		cn.setCid(request.getParameter("cid"));
		cn.setClassname(request.getParameter("classname"));
		ClassDAO dao = new ClassDAO();
		
		int row;
		try {
			try {
				row = dao.updateClassName(cn);
				if(row>0) {
					response.sendRedirect("classeslist.jsp");
				}else {
					pw.println("<html><body><br><br><h4> Class failed to update </h4></body></html> ");
					RequestDispatcher rd= request.getRequestDispatcher("classnew.jsp");
					rd.include(request, response);
				}
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				row = dao.insertClassName(cn);
				if(row>0) {
					response.sendRedirect("classeslist.jsp");
				}else {
					pw.println("<html><body><br><br><h4> Class failed to add </h4></body></html> ");
					RequestDispatcher rd= request.getRequestDispatcher("classnew.jsp");
					rd.include(request, response);
					
				}
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}finally {
			System.out.println("Executed class edit servlet");
		}
			
	} 

}
