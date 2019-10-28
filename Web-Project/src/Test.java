import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import database.PhoneDAO;
import model.Phone;

public class Test {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (new File("data.txt"));
		PhoneDAO dao = PhoneDAO.getInstance();
		ArrayList<Phone> list = dao.getListPhonePage(4);
		System.out.println(list.size());
		for(Phone i: list) {
			System.out.println(i);
		}
	}
}
