package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	public String encryptSHA256(String message) {
		String res = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodeHash = digest.digest(message.getBytes(StandardCharsets.UTF_8));
			res = byteToHex(encodeHash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	private String byteToHex(byte[] hash) {
		StringBuffer str = new StringBuffer();
		for(int i=0; i<hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length()==1)		str.append('0');
			str.append(hex);
		}
		return str.toString();
	}
	
}
