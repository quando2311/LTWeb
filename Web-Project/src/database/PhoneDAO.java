package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Phone;

public class PhoneDAO {
	private static PhoneDAO instance = null;
	private static Connection conn = null;
	private static final int itemsInOnePage = 8;
	private static final String username = "sald";
	private static final String pass = "admiral";
	private static final String url =  "jdbc:sqlserver://localhost:1433;DatabaseName=LTWeb";
	public static int totalPage;
	private PhoneDAO() {
		if(conn == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				this.conn = DriverManager.getConnection(url, username, pass);
				totalPage = this.getTotalPage();
			}catch(SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
	}

	public static PhoneDAO getInstance() {
		if(instance == null) {
			instance = new PhoneDAO();
		}
		return instance;
	}
	
	public void insertPhone(String[] data) {
		
		String sql = "INSERT INTO PhoneTbl (phone_name, price, imgURL, brand, screen, OS, CPU, RAM, camera, battery)" 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try{
			System.out.println(conn == null);
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, data[0]);
			statement.setString(2, data[1]);
			statement.setString(3, data[2]);
			statement.setString(4, data[3]);
			statement.setString(5, data[4]);
			statement.setString(6, data[5]);
			statement.setString(7, data[6]);
			statement.setString(8, data[7]);
			statement.setString(9, data[8]);
			statement.setString(10, data[9]);
			
			int row = statement.executeUpdate();
			System.out.println(row);
		}catch (SQLException e) {
			
		}
	}
	
	public int insertPhone(Phone phone) {
		int isDone = 0;
		String sql = "INSERT INTO PhoneTbl (phone_name, price, imgURL, brand, screen, OS, CPU, RAM, camera, battery)" 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try{
			System.out.println(conn == null);
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, phone.getName());
			statement.setString(2, phone.getPrice());
			statement.setString(3, phone.getImgURL());
			statement.setString(4, phone.getBrand());
			statement.setString(5, phone.getScreen());
			statement.setString(6, phone.getOS());
			statement.setString(7, phone.getCPU());
			statement.setString(8, phone.getRAM());
			statement.setString(9, phone.getCamera());
			statement.setString(10, phone.getBattery());
			
			isDone = statement.executeUpdate();			
		}catch (SQLException e) {
			
		}
		return isDone;
	}
	
	public ArrayList<Phone> getListPhoneAll(){
		ArrayList<Phone> list = new ArrayList<Phone>();
		String sql = "SELECT * FROM PhoneTbl";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				String name = res.getString(2);
				String price = res.getString(3);
				String imageURL = res.getString(4);
				String brand = res.getString(5);
				String screen = res.getString(6);
				String os = res.getString(7);
				String cpu = res.getString(8);
				String ram = res.getString(9);
				String camera = res.getString(10);
				String battery = res.getString(11);
				Phone phone = new Phone(name, price, imageURL, brand, screen, os, cpu, ram, camera, battery);
				phone.setProductId(res.getInt(1));
				list.add(phone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	public ArrayList<Phone> getListPhonePage(int pageId){
		ArrayList<Phone> list = new ArrayList<Phone>();
		int start = 8*(pageId-1), end = 8*pageId;
		String sql = "SELECT * FROM PhoneTbl WHERE phone_id > ? AND phone_id <= ?;";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, start+"");
			statement.setString(2, end+"");
			
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				String name = res.getString(2);
				String price = res.getString(3);
				String imageURL = res.getString(4);
				String brand = res.getString(5);
				String screen = res.getString(6);
				String os = res.getString(7);
				String cpu = res.getString(8);
				String ram = res.getString(9);
				String camera = res.getString(10);
				String battery = res.getString(11);
				Phone phone = new Phone(name, price, imageURL, brand, screen, os, cpu, ram, camera, battery);				
				phone.setProductId(res.getInt(1));
				list.add(phone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	public int getTotalPage() {
		int total = 0;
		String sql = "SELECT COUNT(*) FROM PhoneTbl;";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				total = res.getInt(1);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (total%8==0) ? total: total+1;
	}
	
	public ArrayList<Phone> findPhoneByName(String key){
		ArrayList<Phone> list = new ArrayList<Phone>();
		String sql = "SELECT * FROM PhoneTbl WHERE phone_name LIKE ?";		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+key+"%");
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				String name = res.getString(2);
				String price = res.getString(3);
				String imageURL = res.getString(4);
				String brand = res.getString(5);
				String screen = res.getString(6);
				String os = res.getString(7);
				String cpu = res.getString(8);
				String ram = res.getString(9);
				String camera = res.getString(10);
				String battery = res.getString(11);
				Phone phone = new Phone(name, price, imageURL, brand, screen, os, cpu, ram, camera, battery);
				phone.setProductId(res.getInt(1));
				list.add(phone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	public int deletePhone(int id) {
		int isDone = -1;
		String sql = "DELETE FROM PhoneTbl WHERE phone_id = ?";
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, id+"");
			isDone = ps.executeUpdate();
			System.out.println(isDone);
		} catch (SQLException e) {
			// TODO Auto-generatd catch block
			e.printStackTrace();
		}
		return isDone;
	}
	
	public Phone findPhoneById(int id) {
		Phone phone = null;
		String sql = "SELECT * FROM PhoneTbl WHERE phone_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id+"");
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				String name = res.getString(2);
				String price = res.getString(3);
				String imageURL = res.getString(4);
				String brand = res.getString(5);
				String screen = res.getString(6);
				String os = res.getString(7);
				String cpu = res.getString(8);
				String ram = res.getString(9);
				String camera = res.getString(10);
				String battery = res.getString(11);
				phone = new Phone(name, price, imageURL, brand, screen, os, cpu, ram, camera, battery);				
				phone.setProductId(res.getInt(1));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phone;
	}
	
	public ArrayList<Phone> findPhoneByBrand(String key){
		ArrayList<Phone> list = new ArrayList<Phone>();
		String sql = "SELECT * FROM PhoneTbl WHERE brand LIKE ?";		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+key+"%");
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				String name = res.getString(2);
				String price = res.getString(3);
				String imageURL = res.getString(4);
				String brand = res.getString(5);
				String screen = res.getString(6);
				String os = res.getString(7);
				String cpu = res.getString(8);
				String ram = res.getString(9);
				String camera = res.getString(10);
				String battery = res.getString(11);
				Phone phone = new Phone(name, price, imageURL, brand, screen, os, cpu, ram, camera, battery);				
				phone.setProductId(res.getInt(1));
				list.add(phone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	
}
