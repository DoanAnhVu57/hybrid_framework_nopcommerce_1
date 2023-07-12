package javaOOP.overiding;

public class Employee extends person implements IWork {
	@Override 
	public void eat() {
    	System.out.println("suất cơm 25k");
    }
	@Override
	public void sleep() {
		System.out.println("Ngủ 20p");
	}
	public void workingTime() {
		System.out.println("Học 20p");
		
	}
}
