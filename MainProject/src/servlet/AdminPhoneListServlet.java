package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Phone;
import servlet.utils.APIUtils;

/**
 * Servlet implementation class AdminPhoneListServlet
 */
@WebServlet("/AdminPhoneListServlet")
public class AdminPhoneListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPhoneListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get to admin phone list");
		APIUtils api = new APIUtils();
		String page = request.getParameter("pageId");
		ArrayList<Phone> listPhone = (ArrayList<Phone>) request.getAttribute("list_phone");
		String search_key = request.getParameter("input-phone-name");
		String submit = request.getParameter("submit");
		int pageId = 0;	
				
		
		//Set path for page navigation
		
		String path = "";
		String queryString = request.getQueryString();
		System.out.println("Querys: "+queryString);
		if(queryString != null){				
			int index = queryString.indexOf("pageId");
			System.out.println(index);			
			if(index > 0){
				System.out.println("asdf");
				path = queryString.substring(0, index-1);
			}
			else {
				path = queryString;
			}
		}		
		
		request.setAttribute("path", path);
		
		//Set pagination value
		if(page == null) {
			pageId = 1;			
		}				
		else {
			pageId = Integer.parseInt(page);
		}
		
		//do Get
		
		if(search_key == null && submit == null) {			
			if(listPhone == null) {
				listPhone = api.callPhoneListAPI();
				request.setAttribute("list_phone", listPhone);
			}		
			System.out.println(listPhone.size());
			request.setAttribute("pageId", pageId);
			request.getRequestDispatcher("/view/admin/admin-phone-list.jsp").include(request, response);
		}
		else {
			System.out.println("k");
			String key = request.getParameter("input-phone-name");				
			listPhone = api.findPhoneByName(key);
			request.setAttribute("list_phone", listPhone);
			request.setAttribute("pageId", pageId);
			request.getRequestDispatcher("/view/admin/admin-phone-list.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
