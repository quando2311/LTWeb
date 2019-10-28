package api;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
	
	private String getPhoneJsonFromArr(ArrayList<Phone> arr) {
		String json = "{\"phone\": [";
		for(Phone phone: arr) {
			json += phone + ",";
		}
		json = json.substring(0, json.length()-1) + "]}";
		return json;
		

	}
}
