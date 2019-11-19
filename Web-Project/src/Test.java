import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import database.AdminDAO;
import database.PhoneDAO;
import model.Phone;
import utils.EncryptUtils;

public class Test {
	public static void main(String[] args) throws Exception{
		EncryptUtils encrypt = new EncryptUtils();
		String s = encrypt.encryptSHA256("admin");
		System.out.println(s);
		System.out.println(s.length());
		AdminDAO dao = AdminDAO.getInstance();
		System.out.println(dao.checkLogin("admin", "admin"));
//		URL url = new URL("http://localhost:8080/Web-Project-API/api/user?username=admin&password=123");
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.setRequestMethod("POST");
//		con.setRequestProperty("userId", "abc123");
//		con.setRequestProperty("username", "admin");
//		con.setRequestProperty("password", "123");
//		con.setRequestProperty("Content-Type", "text/plain");
//		
//		con.setDoOutput(true);
//		OutputStream out = con.getOutputStream();
//		out.flush();
//		out.close();
//		
//		int codeResponse = con.getResponseCode();
//		System.out.println(codeResponse);
//		System.out.println(con.getResponseMessage());
////		if(codeResponse == HttpURLConnection.HTTP_CREATED) {
//			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			String input;
//			StringBuffer response = new StringBuffer();
//			while((input = reader.readLine()) != null) {
//				response.append(input);
//			}
//			reader.close();
//			System.out.println(response);
//		}
//		else {
//			System.out.println("Error Post");
//		}
//		
	}
}
