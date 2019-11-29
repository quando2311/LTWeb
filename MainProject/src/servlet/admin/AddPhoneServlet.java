package servlet.admin;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Phone;
import servlet.utils.APIUtils;

/**
 * Servlet implementation class AddPhoneServlet
 */
@WebServlet("/AddPhoneServlet")
@MultipartConfig
public class AddPhoneServlet extends HttpServlet {
	
	public final static String SAVE_IMG_DIR = "C:\\Users\\png99\\OneDrive\\Documents\\Git\\LTWeb\\MainProject\\WebContent\\Image\\PhonesImg";
	private static final long serialVersionUID = 1L;
	       
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
		APIUtils api = new APIUtils();
		request.setCharacterEncoding("UTF-8");
		String name = URLEncoder.encode(request.getParameter("phone_name"), "UTF-8");		
		String price = URLEncoder.encode((request.getParameter("price")+"đ"), "UTF-8");		
		String brand = URLEncoder.encode(request.getParameter("brand"), "UTF-8");		
		String screen = URLEncoder.encode(request.getParameter("screen"), "UTF-8");		
		String os = URLEncoder.encode(request.getParameter("os"), "UTF-8");		
		String cpu = URLEncoder.encode(request.getParameter("cpu"), "UTF-8");		
		String ram = URLEncoder.encode(request.getParameter("ram"), "UTF-8");
		String camera = URLEncoder.encode(request.getParameter("camera"), "UTF-8");		
		String battery = URLEncoder.encode(request.getParameter("battery"), "UTF-8");			
		Part file = request.getPart("img");					
		System.out.println(file.getContentType());
        String fullSavePath = SAVE_IMG_DIR;
        String imgName = request.getParameter("phone_name")+".jpg";
       imgName = imgName.replace(" ", "-");
        Phone phone = new Phone(name, price, URLEncoder.encode("Image/PhonesImg/"+imgName, "UTF-8"), 
        					brand, screen, os, cpu, ram, camera, battery);        
        String imgPath = fullSavePath+File.separator+imgName;
        file.write(imgPath);
        String res = api.addPhone(phone).equals("1") ? "Successfully added": "Fail to add"; 
        System.out.println(request.getQueryString());
        request.setAttribute("message", res);
        request.getRequestDispatcher("/view/admin/add-phone.jsp").include(request, response);
	}

}
