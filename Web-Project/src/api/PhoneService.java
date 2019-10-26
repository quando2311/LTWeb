package api;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import database.PhoneDAO;
import model.Phone;

@Path("/api")
public class PhoneService {
	
	@GET
	@Path("/phones")
	@Produces("application/json")
	public String getListPhonesAll() {
		String json = "{\"phone\": [";
		PhoneDAO dao = PhoneDAO.getInstance();
		ArrayList<Phone> listPhone = dao.getListPhoneAll();
		for(Phone phone: listPhone) {
			json += phone + ",";
		}
		json = json.substring(0, json.length()-1) + "]}";
		return json;
	}
}
