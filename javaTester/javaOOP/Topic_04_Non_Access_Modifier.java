package javaOOP;

public class Topic_04_Non_Access_Modifier {

	//Static: Variable/ Method
	//Dùng chung cho tấc cả các Instance/ Object
	//Phạm vi cho toàn bộ system sử dụng nó:
	//Có thể override được
	static String browserName = "Chrome";
	
	//Non Static
	String serverName = "Testing";
	
	//Hằng số (Final)
	final String colorCar = "Red";
	
	public static void main(String[] args) {
		System.out.println(browserName);
		
		browserName = "Filefox";
		System.out.println(browserName);
		
		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		System.out.println(topic.serverName);
		
		topic.clickToElement("Button");
		senkeyToElement("Link");
		
		//Ko được phép gán lại giá trị
		System.out.println(topic.colorCar);
	}
	
	//Non Static
	public void clickToElement(String elementName) {
		System.out.println(elementName);
	}
    //Static
	public static void senkeyToElement(String elementName) {
		System.out.println(elementName);
	}
	
	//Final
	public final void setCarName() {
		
	}
	
}
