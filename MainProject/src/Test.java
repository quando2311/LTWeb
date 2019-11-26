import java.io.File;
import java.io.IOException;

import model.Phone;
import servlet.utils.APIUtils;
import servlet.utils.JSONUtils;

public class Test {
	public static void main(String[] args) {
		APIUtils api = new APIUtils();
//		System.out.println(api.callPhonePageAPI(1).size());
//		
//		JSONUtils json = new JSONUtils();
//		System.out.println(json.checkLoginFromJSON("{\"status\": \"true\"}"));
		
//		File f = new File("WebContent\\Image\\PhonesImg\\dat.txt");
//		try {
//			f.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Phone phone = new Phone("test", "test", "test", "test", "test", 
				"test", "test", "test", "test", "test");
		api.addPhone(phone);
	}
}
