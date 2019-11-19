package api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import database.AdminDAO;

@Path("/api")
public class UserService {

	@POST
	@Path("/user")
	@Consumes("text/plain")	
	@Produces("application/json")
	public String logIn(
			@QueryParam("username") String username, 
			@QueryParam("password") String password
			) {
		boolean isValid = false;		
		if(username != null && password != null) {			
			AdminDAO dao = AdminDAO.getInstance();
			isValid = dao.checkLogin(username, password);				
		}
		return "{\"status\": \"" + isValid +"\"}";
	}
	
}
