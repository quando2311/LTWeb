import java.io.File;
import java.util.Scanner;

import database.PhoneDAO;

public class Test {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (new File("data.txt"));
		PhoneDAO dao = PhoneDAO.getInstance();
		while(sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(s);
			String arr[] = s.split("\\^");
			dao.insertPhone(arr);
		}
	}
}
