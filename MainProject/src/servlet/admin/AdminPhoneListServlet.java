package servlet.admin;

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
		if(request.getSession().getAttribute("username") == null) {
			request.getRequestDispatcher("view/admin/unauthorize.html").include(request, response);
			return;
		}
		APIUtils api = new APIUtils();
		int totalPage = 0;
		String page = request.getParameter("pageId");
		ArrayList<Phone> listPhone = (ArrayList<Phone>) request.getAttribute("list_phone");
		String search_key = request.getParameter("input-phone-name");
		String submit = request.getParameter("submit");
		int pageId = 0;	
				
		
		//Set path for page navigation	
		String queryString = request.getQueryString();
		
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
			
			totalPage = listPhone.size()/8;
			if(listPhone.size()%8 != 0)	totalPage++;
			
			if(pageId==0)	pageId=1;
			if(pageId >= totalPage)	pageId = totalPage;
			System.out.println("pageId: "+pageId);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageId", pageId);
			request.getRequestDispatcher("/view/admin/admin-phone-list.jsp").include(request, response);
		}
		else {			
			String key = request.getParameter("input-phone-name");				
			listPhone = api.findPhoneByNameAPI(key);
			totalPage = listPhone.size()/8;
			if(listPhone.size()%8 != 0)	totalPage++;
			
			request.setAttribute("list_phone", listPhone);
			request.setAttribute("totalPage", totalPage);
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
