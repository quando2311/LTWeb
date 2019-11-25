package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.EncryptUtils;

public class AdminDAO {
	private static AdminDAO instance;
	private static Connection conn = null;
	private static final int itemsInOnePage = 8;
	private static final String username = "sald";
	private static final String pass = "admiral";
	private static final String url =  "jdbc:sqlserver://localhost:1433;DatabaseName=LTWeb";
	public static int totalPage;
	private AdminDAO() {
		if(conn == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				this.conn = DriverManager.getConnection(url, username, pass);
				
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}		
	}

	public static AdminDAO getInstance() {
		if(instance == null) {
			instance = new AdminDAO();
		}
		return instance;
	}
	
	
	public boolean checkLogin(String username, String password) {
		boolean isValid = false;
		EncryptUtils encrypt = new EncryptUtils();
		username = encrypt.encryptSHA256(username);
		password = encrypt.encryptSHA256(password);
		String sql = "SELECT * FROM AdminTbl WHERE USERNAME = ? AND PASSWORD = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet res = ps.executeQuery();
			isValid = res.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
	
	public int changePassword(String username, String password, String newPassword) {
		int isValid = 0;
		
		EncryptUtils encrypt = new EncryptUtils();
		username = encrypt.encryptSHA256(username);
		password = encrypt.encryptSHA256(password);
		newPassword = encrypt.encryptSHA256(newPassword);
		String sql = "UPDATE AdminTbl SET PASSWORD = ? WHERE USERNAME = ? AND PASSWORD = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, username);
			ps.setString(3, password);
			isValid = ps.executeUpdate();
			System.out.println(isValid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
	
}
