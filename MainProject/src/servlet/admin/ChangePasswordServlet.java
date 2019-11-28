package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.utils.APIUtils;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("username") == null) {
			request.getRequestDispatcher("view/admin/unauthorize.html").include(request, response);
			return;
		}
		request.getRequestDispatcher("view/admin/change-password.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		APIUtils api = new APIUtils();
		String resp = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("new-password");
		String confirmPassword = request.getParameter("confirm-password");
		if(!newPassword.equals(confirmPassword)) {
			resp = "New password does not matched";
			request.setAttribute("message", resp);
			request.getRequestDispatcher("view/admin/change-password.jsp").include(request, response);
		}
		else {
			System.out.println(username + "-" + password + "-" + newPassword);
			resp = api.changePasswordAPI(username, password, newPassword);			
			System.out.println(resp);
			if(resp.equals("Invalid account")){
				request.setAttribute("message", resp);
				request.getRequestDispatcher("view/admin/change-password.jsp").include(request, response);
			}
			else {
				Set<String> listUser = (Set<String>) getServletContext().getAttribute("list_user");
				listUser.remove(request.getSession().getAttribute("username"));
				request.getSession().setAttribute("username", null);				
				request.getSession().invalidate();		
				response.sendRedirect("admin");
			}
		}				
				
	}

}
