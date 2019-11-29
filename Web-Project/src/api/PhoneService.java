package api;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import database.PhoneDAO;
import model.Phone;

@Path("/api")
public class PhoneService {
	
	@GET
	@Path("/phones")
	@Produces("application/json")
	public String getListPhonesAll() {		
		PhoneDAO dao = PhoneDAO.getInstance();
		ArrayList<Phone> listPhone = dao.getListPhoneAll();
		return getPhoneJsonFromArr(listPhone);
	}
	
	@GET 
	@Path("/phone")
	@Produces("application/json")
	public String getListPhonePage(@QueryParam("page") int pageId) {		
		PhoneDAO dao = PhoneDAO.getInstance();
		ArrayList<Phone> listPhone = dao.getListPhonePage(pageId);
		return getPhoneJsonFromArr(listPhone);
	}
	
	@POST
	@Path("/phone")
	@Produces("application/json")
	public String findPhoneByName(@QueryParam("phone-name") String key) {
		System.out.println("Phone-name: "+key);
		PhoneDAO dao = PhoneDAO.getInstance();
		ArrayList<Phone> list = dao.findPhoneByName(key);
		return getPhoneJsonFromArr(list);
	}
	
	@GET
	@Path("/phone/delete")
	@Produces("application/json")
	public String deletePhone(@QueryParam("phone-id") int key) {
		PhoneDAO dao = PhoneDAO.getInstance();
		System.out.println("delete phone");
		int isDone = dao.deletePhone(key);
		return "{\"status\": \""+isDone+"\"}";
	}
	
	@POST 
	@Path("/add-phone")
	@Produces("application/json")
	public String addPhone(@QueryParam("phone-name") String phoneName, 
						@QueryParam("price") String price, 
						@QueryParam("img") String imgURL,
						@QueryParam("brand") String brand,
						@QueryParam("screen") String screen,
						@QueryParam("os") String os,
						@QueryParam("cpu") String cpu,
						@QueryParam("ram") String ram,
						@QueryParam("camera") String camera,
						@QueryParam("battery") String battery) {
		Phone phone = new Phone(phoneName, price, imgURL, brand, screen, os, cpu, ram, camera, battery);
		PhoneDAO dao = PhoneDAO.getInstance();
		int res = dao.insertPhone(phone);
		System.out.println(String.format("%s--%s--%s--%s--%s--%s--%s--%s--%s--%s", phoneName, 
							price, imgURL, brand, screen, os, cpu, ram, camera, battery));
		
		return "{\"status\": \""+res+"\"}";
	}
	
	@POST 
	@Path("/find-phone/id")
	@Produces("application/json")
	public String findPhoneById(@QueryParam("id") int id) {
		PhoneDAO dao = PhoneDAO.getInstance();
		Phone phone = dao.findPhoneById(id);
		return phone != null? phone.toString(): "{\"status\": \"Not found.\"}";
	}
	
	@POST 
	@Path("/find-phone/brand")
	@Produces("application/json")
	public String findPhoneByBrand(@QueryParam("brand") String brand) {
		PhoneDAO dao = PhoneDAO.getInstance();
		ArrayList<Phone> listPhone = dao.findPhoneByBrand(brand);
		return getPhoneJsonFromArr(listPhone);
	}
	
	@POST 
	@Path("/edit-phone")
	@Produces("application/json")
	public String editPhone(@QueryParam("id") String id,
							@QueryParam("phone-name") String phoneName, 
							@QueryParam("price") String price, 
							@QueryParam("img") String imgURL,
							@QueryParam("brand") String brand,
							@QueryParam("screen") String screen,
							@QueryParam("os") String os,
							@QueryParam("cpu") String cpu,
							@QueryParam("ram") String ram,
							@QueryParam("camera") String camera,
							@QueryParam("battery") String battery) {
		
		imgURL = imgURL.substring(imgURL.indexOf("Image"));
		
		Phone phone = new Phone(phoneName, price, imgURL, brand, screen, os, cpu, ram, camera, battery);
		phone.setProductId(Integer.parseInt(id));
		phone.setImgURL(imgURL);
		PhoneDAO dao = PhoneDAO.getInstance();
		int res = dao.updatePhone(phone);
		return "{\"status\": \"" + 1 + "\"}";
	}
	
	private String getPhoneJsonFromArr(ArrayList<Phone> arr) {
		String json = "{\"phone\": [";
		for(Phone phone: arr) {
			json += phone + ",";
		}
		json = json.substring(0, json.length()-1) + "]}";
		return json;		
	}
	
}
