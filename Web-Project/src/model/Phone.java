package model;

public class Phone {
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
		return String.format(s, name, price, "localhost:8080/ImageStorage/"+imgURL, brand, screen, OS, CPU, RAM, camera, battery);
	}
	
	
}

//fetch('http://localhost:8080/Web-Project-API/api/phones', { mode: 'no-cors'})
//.then((response) => response.json())
//.then((data) => {
//	console.log(data);
//	})

