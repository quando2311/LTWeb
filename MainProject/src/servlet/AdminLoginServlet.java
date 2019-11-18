package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/admin/admin-login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username") + "";
		String password = request.getParameter("password") + "";
		System.out.println(username + " " + password);
		if(request.getSession().getAttribute("username") != null) {
			request.setAttribute("message", "Account is already in used");
			request.getRequestDispatcher("view/admin/admin-login.jsp").include(request, response);
		}
		else {
			if(username.equals("admin") && password.equals("123")) {

				request.getSession().setAttribute("username", username);
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin-home");
//				request.getRequestDispatcher("admin-home").forward(request, response);	
				response.sendRedirect("admin-home");
			}
			else {
				request.setAttribute("message", "Invalid account");
				request.getRequestDispatcher("/view/admin/admin-login.jsp").include(request, response);
			}
		}		
	}

}
