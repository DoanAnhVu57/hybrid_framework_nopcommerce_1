package javaOOP;

public class Topic_02_Variable_Method_Property {
    //Access Modifier
    //Data Type
	//Variable name
	//Variable value
	private String studentName ="automation FC"; // biến toàn cục: global variable
	
	// Static variable
	public static String studentAddress = "Ho Chi Minh";
	private static String studentPhone = "0987654321";
	
	//Final variable
	final String country = " Viet Nam";
	
	//Static final variable
	static final float PI_NUMBER = 3.14446f;
	
	//Access Modifier: default
	int studentID = 10002;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Topic_02_Variable_Method_Property() {
		String studentName = "Automation FC";
		//Local variable - biến cục bộ: hàm/ block code/ contrucstor
	}
	
	//Hàm( Method)
	public void display() {
		//Local variable - biến cục bộ: hàm/ block code/ contrucstor
		String studentName = "Automation FC";
		
	}

}
