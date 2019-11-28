package servlet.admin;

import java.io.IOException;
import java.util.Set;

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
		if(request.getSession().getAttribute("username") == null) {
			request.getRequestDispatcher("view/admin/unauthorize.html").include(request, response);
			return;
		}
		request.getRequestDispatcher("view/admin/admin-home.jsp").include(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("submit") != null) {
			doGet(request, response);
		}
		else {
			String post_value = request.getParameter("navigation");
			System.out.println("post to home" + post_value);
			switch(post_value) {
				case "Log Out":
					Set<String> listUser = (Set<String>) getServletContext().getAttribute("list_user");
					listUser.remove(request.getSession().getAttribute("username"));
					request.getSession().setAttribute("username", null);				
					request.getSession().invalidate();
					request.setAttribute("message", "");
					response.sendRedirect("admin");
					break;					
				case "Home":
					response.sendRedirect("admin-home");
					break;
					
				case "Change Password":
					response.sendRedirect("change-password");
					break;
				default: 
					break;
			}
		}
				
	}

}
