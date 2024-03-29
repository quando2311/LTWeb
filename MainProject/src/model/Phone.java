package model;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Phone {
	private int id;
	private String name, price, imgURL, brand, screen, OS, CPU, RAM, camera, battery;

	public Phone(String name, String price, String imgURL, String brand, String screen, String oS, String cPU,
			String rAM, String camera, String battery) {
		this.name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		this.price = price;
		this.imgURL = imgURL.replace(' ', '-');
		this.brand = brand;
		this.screen = screen;
		OS = oS;
		CPU = cPU;
		RAM = rAM;
		this.camera = camera;
		this.battery = battery;
	}
	
	public Phone(String[] arr) {
		this.name = arr[0];
		this.price = arr[1];
		this.imgURL = arr[2];
		this.brand = arr[3];
		this.screen = arr[4];
		OS = arr[5];
		CPU = arr[6];
		RAM = arr[7];
		this.camera = arr[8];
		this.battery = arr[9];		
	}

	
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}
	
	public String[] getStringArrayField() {
		String[] arr = new String[10];
		arr[0] = this.name;
		arr[1] = this.price;
		arr[2] = this.imgURL;
		arr[3] = this.brand;
		arr[4] = this.screen;
		arr[5] = this.OS;
		arr[6] = this.CPU;
		arr[7] = this.RAM;
		arr[8] = this.camera;
		arr[9] = this.battery;
		System.out.println(Arrays.deepToString(arr));
		return arr;
	}

	@Override
	public String toString() {
		String s = "{ \"name\": \"%s\", "
				+ "\"price\": \"%s\", "
				+ "\"imgURL\": \"%s\", "
				+ "\"brand\": \"%s\", "
				+ "\"screen\": \"%s\", "
				+ "\"os\": \"%s\", "
				+ "\"cpu\": \"%s\", "
				+ "\"ram\": \"%s\", "
				+ "\"camera\": \"%s\", "
				+ "\"battery\": \"%s\" "
				+ "}";
		return String.format(s, name, price, imgURL, brand, screen, OS, CPU, RAM, camera, battery);
	}
	
	
}

//fetch('http://localhost:8080/Web-Project-API/api/phones', { mode: 'no-cors'})
//.then((response) => response.json())
//.then((data) => {
//	console.log(data);
//	})

