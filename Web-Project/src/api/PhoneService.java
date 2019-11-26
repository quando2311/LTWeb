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
	
	
	private String getPhoneJsonFromArr(ArrayList<Phone> arr) {
		String json = "{\"phone\": [";
		for(Phone phone: arr) {
			json += phone + ",";
		}
		json = json.substring(0, json.length()-1) + "]}";
		return json;		
	}
}
