
package javaOOP;

public class Testing {

	public static void main(String[] args) {
		//Truy cập trực tiếp từ tên Class, ko cần tạo Instance/Object
		//Ko nên lạm dụng tạo các biến static
		
		System.out.println(Topic_04_Non_Access_Modifier.browserName);
	
	Topic_04_Non_Access_Modifier.senkeyToElement("Link");

	Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
	System.out.println(topic.colorCar);
	}
}