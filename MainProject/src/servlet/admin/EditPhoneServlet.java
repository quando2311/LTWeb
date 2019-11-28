package servlet.admin;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Phone;
import servlet.utils.APIUtils;

/**
 * Servlet implementation class EditPhoneServlet
 */
@WebServlet("/EditPhoneServlet")
public class EditPhoneServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = request.getParameter("id");		
		if(id != null) {
			Phone phone = findPhone(id);
			System.out.println(phone);
			request.setAttribute("phone", phone);
			request.getRequestDispatcher("view/admin/edit-phone.jsp").forward(request, response);
		}
		else {
			System.out.println(request.getQueryString());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		APIUtils api = new APIUtils();
		System.out.println(request.getRequestURL());
		System.out.println(request.getQueryString());
		response.getWriter().write("Posted");
	}

	private Phone findPhone(String id) {
		Phone phone = null;
		APIUtils api = new APIUtils();
		phone = api.findPhoneByIdAPI(id);
		return phone;
	}
	
}
