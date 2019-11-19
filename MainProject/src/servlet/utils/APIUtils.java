package servlet.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIUtils {
	
	public static final String USER_API = "http://localhost:8080/Web-Project-API/api/user";
	public static final String PHONES_API = "http://localhost:8080/Web-Project-API/api/phones";
	
	public boolean callAdminLoginAPI(String username, String password) {
		System.out.println("calling API to check login");
		boolean isValid = false;
		JSONUtils jsonUtil = new JSONUtils();
		try {
			String path = USER_API + "?username="+username+"&password=" + password;
			System.out.println(path);
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("userId", "abc123");
			con.setRequestProperty("username", username);
			con.setRequestProperty("password", password);
			con.setRequestProperty("Content-Type", "text/plain");
						
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			out.flush();
			out.close();
			
			int codeResponse = con.getResponseCode();
			System.out.println("Code response is: "+codeResponse);
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			StringBuffer response = new StringBuffer();
			while((input = reader.readLine()) != null) {
				response.append(input);
			}
			reader.close();
			System.out.println(response);
			isValid = jsonUtil.checkLoginFromJSON(response.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return isValid;
	}
}
