package servlet.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

import model.Phone;

public class APIUtils {
	
	public static final String USER_API = "http://localhost:8080/Web-Project-API/api/user";
	public static final String CHANGE_PASSWORD_API = "http://localhost:8080/Web-Project-API/api/change-password";
	public static final String PHONES_API = "http://localhost:8080/Web-Project-API/api/phones";
	public static final String PHONES_PAGE = "http://localhost:8080/Web-Project-API/api/phone";
	public static final String ADD_PHONE_API = "http://localhost:8080/Web-Project-API/api/add-phone";
	public boolean callAdminLoginAPI(String username, String password) {
		System.out.println("calling API to check login");
		boolean isValid = false;
		JSONUtils jsonUtil = new JSONUtils();
		try {
			String path = USER_API + "?username="+username+"&password=" + password;
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
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			StringBuffer response = new StringBuffer();
			while((input = reader.readLine()) != null) {
				response.append(input);
			}
			reader.close();
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
	
	public String changePasswordAPI(String username, String password, String newPassword) {
		System.out.println("calling API to change password");
		String value = null;
		JSONUtils jsonUtil = new JSONUtils();
		try {
			String path = CHANGE_PASSWORD_API + "?username="+username+
					"&password="+password+"&new-password="+newPassword;
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("username", username);
			con.setRequestProperty("password", password);
			con.setRequestProperty("Content-Type", "text/plain");
						
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			out.flush();
			out.close();
			
			int codeResponse = con.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			StringBuffer response = new StringBuffer();
			while((input = reader.readLine()) != null) {
				response.append(input);
			}
			reader.close();
			value = jsonUtil.checkChangePasswordFromJSON(response.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return value;
	}
	
	public ArrayList<Phone> callPhoneListAPI(){
		ArrayList<Phone> list = new ArrayList<Phone>();
		JSONUtils utils = new JSONUtils();
		try {
			InputStream inp = new URL(PHONES_API).openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inp, Charset.forName("UTF-8")));
			StringBuffer str = new StringBuffer();
			String input;
			while((input = reader.readLine()) != null) {
				str.append(input);
			}			
			reader.close();
			list = utils.getListPhoneFromJSON(str.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Phone> callPhonePageAPI(int page){
		ArrayList<Phone> list = new ArrayList<Phone>();
		JSONUtils utils = new JSONUtils();
		try {
			InputStream inp = new URL(PHONES_PAGE+"?page="+page).openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inp, Charset.forName("UTF-8")));
			StringBuffer str = new StringBuffer();
			String input;
			while((input = reader.readLine()) != null) {
				str.append(input);
			}			
			reader.close();
			list = utils.getListPhoneFromJSON(str.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Phone> findPhoneByName(String key){
		ArrayList<Phone> list = new ArrayList<Phone>();
		JSONUtils utils = new JSONUtils();
		try {
			URL url = new URL(PHONES_PAGE+"?phone-name="+key);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("userId", "abc123");
			con.setRequestProperty("Content-Type", "text/plain");
			
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			out.flush();
			out.close();
			
			
			int codeResponse = con.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			StringBuffer response = new StringBuffer();
			while((input = reader.readLine()) != null) {
				response.append(input);
			}
			reader.close();			
			list = utils.getListPhoneFromJSON(response.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}
	
	public void addPhone(Phone phone){
		ArrayList<Phone> list = new ArrayList<Phone>();
		String queryString = String.format("?phone-name=%s&price=%s&img=%s&brand=%s&screen=%s"
								+ "&os=%s&cpu=%s&ram=%s&camera=%s&battery=%s", 
								phone.getName(), phone.getPrice(), phone.getImgURL(), 
								phone.getBrand(), phone.getScreen(), phone.getOS(), phone.getCPU(), 
								phone.getRAM(), phone.getCamera(), phone.getBattery());
		JSONUtils utils = new JSONUtils();
		try {
			URL url = new URL(ADD_PHONE_API+ queryString);
			System.out.println(ADD_PHONE_API+queryString);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("userId", "abc123");
			con.setRequestProperty("Content-Type", "text/plain");
			
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			out.flush();
			out.close();
								
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			StringBuffer response = new StringBuffer();
			while((input = reader.readLine()) != null) {
				response.append(input);
			}
			reader.close();			
//			list = utils.getListPhoneFromJSON(response.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	
}
