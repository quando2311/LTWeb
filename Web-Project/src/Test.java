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
//		EncryptUtils encrypt = new EncryptUtils();
//		String s = encrypt.encryptSHA256("admin");
//		System.out.println(s);
//		System.out.println(s.length());
//		AdminDAO dao = AdminDAO.getInstance();
//		System.out.println(dao.checkLogin("admin", "admin"));

		PhoneDAO dao = PhoneDAO.getInstance();
		ArrayList<Phone> list = dao.findPhoneByName("SamSung");
		System.out.println(list.toString());
	}
}
