package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminHomeServlet
 */
//@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get to home");
		request.getRequestDispatcher("view/admin/admin-home.jsp").include(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post to home");

		if(request.getParameter("submit") != null) {
			doGet(request, response);
		}
		else {
			String post_value = request.getParameter("navigation");
			if(post_value.equals("Log Out")) {
				request.getSession().setAttribute("username", null);
				request.getSession().invalidate();
				request.setAttribute("message", "");
				response.sendRedirect("admin");
			}	
		}
				
	}

}
