import servlet.utils.APIUtils;
import servlet.utils.JSONUtils;

public class Test {
	public static void main(String[] args) {
		APIUtils api = new APIUtils();
		System.out.println(api.callAdminLoginAPI("admin", "admin"));
		
//		JSONUtils json = new JSONUtils();
//		System.out.println(json.checkLoginFromJSON("{\"status\": \"true\"}"));
		
	}
}
