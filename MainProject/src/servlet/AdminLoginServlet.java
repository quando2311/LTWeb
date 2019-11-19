package servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.utils.APIUtils;

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
		Cookie[] cookies = request.getCookies();
		Set<String> listUser = (Set<String>) getServletContext().getAttribute("list_user");
		if(listUser == null) {
			listUser = new HashSet<String>();
		}
		if(listUser.contains(username)) {
			request.setAttribute("message", "Account is already in used");
			request.getRequestDispatcher("view/admin/admin-login.jsp").include(request, response);
		}
		else {
			APIUtils apiUtil = new APIUtils();
			boolean validLogin = apiUtil.callAdminLoginAPI(username, password);
			if(validLogin) {

				request.getSession().setAttribute("username", username);
				listUser.add(username);
				getServletContext().setAttribute("list_user", listUser);
				
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
