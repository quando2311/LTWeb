package model;

public class Phone {
	private int productId;
	private String name, price, imgURL, brand, screen, OS, CPU, RAM, camera, battery;

	public Phone(String name, String price, String imgURL, String brand, String screen, String oS, String cPU,
			String rAM, String camera, String battery) {
		this.name = name;
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

		
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		String s = "{ \"productId\": \"%s\", " 
				+ "\"name\": \"%s\", "
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
		return String.format(s, productId, name, price, "localhost:8080/MainWebProject/"+imgURL, brand, screen, OS, CPU, RAM, camera, battery);
	}
	
	
}

//fetch('http://localhost:8080/Web-Project-API/api/phones', { mode: 'no-cors'})
//.then((response) => response.json())
//.then((data) => {
//	console.log(data);
//	})

