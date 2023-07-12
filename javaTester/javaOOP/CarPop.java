package javaOOP;

public class CarPop {
    
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;
	
	public static void main(String[] args) {
		carCompany ="Honda";
		carType ="Crv";
		fuelType ="Petro";
		mileAge =120f;
		carPrice = 20000d;
		
		System.out.print("Car company = " + carCompany );
		System.out.print("Car Type = " + carType );
		System.out.print("Car fuel Type = " + fuelType );
		System.out.print("Car mile Age = " + mileAge );
		System.out.print("Car Price = " + carPrice );

	}

}
