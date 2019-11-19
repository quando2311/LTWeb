package servlet.utils;

import org.json.JSONObject;

public class JSONUtils {

	public boolean checkLoginFromJSON(String jsonStr) {
		boolean isValid = false;
		JSONObject jsonObj = new JSONObject(jsonStr);
		String value = (String) jsonObj.get("status");
		isValid = value.equals("true")? true: false;
		return isValid;
	}
	
}
