package servlet.admin;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

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
 * Servlet implementation class EditPhoneServlet
 */

@WebServlet("/EditPhoneServlet")
@MultipartConfig
public class EditPhoneServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = request.getParameter("id");		
		if(id != null) {
			Phone phone = findPhone(id);			
			request.setAttribute("phone", phone);
			request.getRequestDispatcher("view/admin/edit-phone.jsp").forward(request, response);
		}
		else {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		APIUtils api = new APIUtils();
		String name = request.getParameter("phone_name");
		Phone phone = getInfoFromQueryString(request);
		String res = api.editPhone(phone).equals("1")? "Success": "Fail";
		request.setAttribute("phone", phone);
		request.setAttribute("message", res);
		request.getRequestDispatcher("view/admin/edit-phone.jsp").include(request, response);
	}

	private Phone findPhone(String id) {
		Phone phone = null;
		APIUtils api = new APIUtils();
		phone = api.findPhoneByIdAPI(id);
		return phone;
	}
	
	private Phone getInfoFromQueryString(HttpServletRequest request) throws IOException, ServletException {
		String id = request.getParameter("id");
		String phoneName = request.getParameter("phone_name");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		String screen = request.getParameter("screen");
		String os = request.getParameter("os");
		String cpu = request.getParameter("cpu");
		String ram = request.getParameter("ram");
		String camera = request.getParameter("camera");
		String battery = request.getParameter("battery");
		String imgURL = "";
		Part file = request.getPart("img");		
		System.out.println(phoneName);		
		System.out.println(file.getContentType());
		if(file.getContentType().equals("image/jpeg")){
			String fullSavePath = AddPhoneServlet.SAVE_IMG_DIR;
	        String imgName = request.getParameter("phone_name")+".jpg";
	        String imgPath = fullSavePath+File.separator+imgName;
	        System.out.println("Path: " + imgPath);
	        file.write(imgPath);
	        imgURL = "Image/PhonesImg/"+imgName;
		}
		Phone original = findPhone(id);
		Phone editted = new Phone(phoneName, price, imgURL, brand, screen, os, cpu, ram, camera, battery); 
		editted = checkModified(original, editted);
		System.out.println(editted);
		editted = encodeQueryString(editted);

		return editted;
	}
	
	private Phone checkModified(Phone original, Phone editted) {
		String[] originalField = original.getStringArrayField();
		String[] edittedField = editted.getStringArrayField();
		
		for(int i=0; i<originalField.length; i++) {
			if(!originalField[i].equals(edittedField[i])) {
				originalField[i] = edittedField[i];
				if(i==2 && edittedField[i].equals("")) {
					originalField[i] = original.getImgURL();
				}
			}
		}
		originalField[0] = originalField[0].replace(" ", "-");
		Phone res = new Phone(originalField);
		res.setId(original.getId());
		
		return res;
		
	}
	
	private Phone encodeQueryString(Phone phone) {		
		phone.setName(URLEncoder.encode(phone.getName()));
		phone.setPrice(URLEncoder.encode(phone.getPrice()));
		phone.setBrand(URLEncoder.encode(phone.getBrand()));
		phone.setImgURL(URLEncoder.encode(phone.getImgURL()));
		phone.setOS(URLEncoder.encode(phone.getOS()));
		phone.setCPU(URLEncoder.encode(phone.getCPU()));
		phone.setScreen(URLEncoder.encode(phone.getScreen()));
		phone.setCamera(URLEncoder.encode(phone.getCamera()));
		phone.setRAM(URLEncoder.encode(phone.getRAM()));
		phone.setBattery(URLEncoder.encode(phone.getBattery()));
		
		return phone;
	}
	
}
