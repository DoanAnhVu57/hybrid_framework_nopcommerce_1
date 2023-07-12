package javaOOP;

public class Topic_03_Method {
	void showCarName() {
		System.out.println("Honda Crv");
	}
	static void showCarColor() {
		System.out.println("Red");
	}
	
	public static void main(String[] args) {
		//Gọi vào trogng 1 static khác được
		showCarColor();
		
		//Gọi qua instance/ Object
		Topic_03_Method ojb = new Topic_03_Method();
		ojb.showCarName();
}
	}
