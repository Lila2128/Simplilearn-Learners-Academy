package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		PrintWriter pw= response.getWriter();
		
		if(user.equals(password)) {
			RequestDispatcher rd=request.getRequestDispatcher("classeslist.jsp");
			rd.include(request, response);
//			pw.println("successully login");
			
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			pw.print("Incorrect login and password");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		PrintWriter pw= response.getWriter();
		
		if(user.equals(password)) {
			RequestDispatcher rd=request.getRequestDispatcher("classeslist.jsp");
			rd.include(request, response);
//			pw.println("successully login");
			
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			pw.print("Incorrect login and password");
		}
	}

}
