package servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddPhoneServlet
 */
@WebServlet("/AddPhoneServlet")
@MultipartConfig
public class AddPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = 
	            Logger.getLogger(AddPhoneServlet.class.getCanonicalName());       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getQueryString());
		request.getRequestDispatcher("view/admin/add-phone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(Part part: request.getParts()) {
			System.out.println(part.getHeader("Content-Disposition"));
			System.out.println(part.getHeader("Content-Type"));
			
		}
	}

}
