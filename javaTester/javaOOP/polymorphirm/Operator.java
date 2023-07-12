package javaOOP.polymorphirm;

public class Operator {
	public void sum(int a, int b) {
		System.out.println(a+b);
	}
	public void sum(double a, double b) {
		System.out.println(a+b);
	}
	public void sum(float a, float b) {
		System.out.println(a+b);
	}
	public void sum(long a, long b) {
		System.out.println(a+b);
	}
	 Operator opr = new Operator();
	

	public static void main(String[] args) {
		Operator opr = new Operator();
		 opr.sum(2, 3);
		 opr.sum(2.343f, 3.233f);
         opr.sum(2.1d, 3.12d);
         opr.sum(2000l, 3000l);
	}

}
