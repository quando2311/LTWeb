package api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/api")
public class UserService {

	@POST
	@Path("/user")
	@Consumes("text/plain")	
	@Produces("application/json")
	public void logIn(
			@QueryParam("username") String username, 
			@QueryParam("password") String password
			) {
		System.out.println(username + "   " + password);
	}
	
}
