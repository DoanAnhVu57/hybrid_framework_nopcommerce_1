package javaOOP;

public class CarOOP {
	// Thuộc tính
	private String carCompany;
	private String carType;
	private String fuelType;
	private Float mileAge;
	private Double carPrice;

	protected CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
		super();
		this.carCompany = carCompany;
		this.carType = carType;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}

	protected final String getCarCompany() {
		return carCompany;
	}

	protected final void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	protected final String getCarType() {
		return carType;
	}

	protected final void setCarType(String carType) {
		this.carType = carType;
	}

	protected final String getFuelType() {
		return fuelType;
	}

	protected final void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	protected final Float getMileAge() {
		return mileAge;
	}

	protected final void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}

	protected final Double getCarPrice() {
		return carPrice;
	}

	protected final void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	protected void showCarInfor() {
		System.out.print("Car company = " + getCarCompany());
		System.out.print("Car Type = " + getCarType());
		System.out.print("Car fuel Type = " + getFuelType());
		System.out.print("Car mile Age = " + getMileAge());
		System.out.print("Car Price = " + getCarPrice());
	}

	public static void main(String[] args) {
		// Honda
		CarOOP honda = new CarOOP("Honda", "Crv", "Petro", 120f, 20000d);
		honda.showCarInfor();

		// Honda
		CarOOP mazda = new CarOOP("Mazda", "Mazda3", "Petro", 130f, 30000d);
		mazda.showCarInfor();

	}

}
