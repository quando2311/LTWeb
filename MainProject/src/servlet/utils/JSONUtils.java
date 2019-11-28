package servlet.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Phone;

public class JSONUtils {

	public boolean checkLoginFromJSON(String jsonStr) {
		boolean isValid = false;
		JSONObject jsonObj = new JSONObject(jsonStr);
		String value = (String) jsonObj.get("status");
		isValid = value.equals("true")? true: false;
		return isValid;
	}
	
	public String checkChangePasswordFromJSON(String jsonStr) {
		JSONObject jsonObj = new JSONObject(jsonStr);
		String value = (String) jsonObj.get("status");
		return value;
	}
	
	public String checkAddPhone(String jsonStr) {
		JSONObject jsonObj = new JSONObject(jsonStr);
		String value = (String) jsonObj.get("status");
		return value;
	}
	
	public ArrayList<Phone> getListPhoneFromJSON(String jsonStr){
		ArrayList<Phone> list = new ArrayList<Phone>();
		
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		System.out.println(jsonStr);
		
		JSONArray arrJSON = (JSONArray) jsonObj.get("phone");
		for(int i=0; i<arrJSON.length(); i++) {
			JSONObject obj = arrJSON.getJSONObject(i);
			String name = new String(((String)obj.get("name")).getBytes(), StandardCharsets.UTF_8);
			String price = (String) obj.get("price");
			String url = (String) obj.get("imgURL");
			String brand = (String) obj.get("brand");
			String screen = (String) obj.get("screen");
			String os = (String) obj.get("os");
			String cpu = (String) obj.get("cpu");
			String ram = (String) obj.get("ram");
			String camera = (String) obj.get("camera");
			String battery = (String) obj.get("battery");
									
			Phone phone = new Phone(name, price, url, brand, screen, os, cpu, ram, camera, battery);
			phone.setId(Integer.parseInt((String) obj.get("productId")));
			list.add(phone);			
		}
		
		return list;
	}
	
	public Phone getPhoneFromJSON(String jsonStr){
		Phone phone = null;
		
		JSONObject obj = new JSONObject(jsonStr);			
		
		String name = new String(((String)obj.get("name")).getBytes(), StandardCharsets.UTF_8);
		String price = (String) obj.get("price");
		String url = (String) obj.get("imgURL");
		String brand = (String) obj.get("brand");
		String screen = (String) obj.get("screen");
		String os = (String) obj.get("os");
		String cpu = (String) obj.get("cpu");
		String ram = (String) obj.get("ram");
		String camera = (String) obj.get("camera");
		String battery = (String) obj.get("battery");
									
		phone = new Phone(name, price, url, brand, screen, os, cpu, ram, camera, battery);
		phone.setId(Integer.parseInt((String) obj.get("productId")));
						
		
		return phone;
	}
	
	
}
