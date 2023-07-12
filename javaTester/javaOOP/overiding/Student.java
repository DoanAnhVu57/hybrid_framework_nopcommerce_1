package javaOOP.overiding;

public class Student extends person implements IWork{
	@Override
	public void eat() {
		System.out.println("suất cơm 15k");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 10p");
	}

	public void workingTime() {
		System.out.println("Học 10p");
		
	}
}
