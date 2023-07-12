package javaOOP.overiding;

public class Testing {
    public static void main(String[] args) {
	
        Student s = new Student();
        s.eat();
        s.sleep();
        
        Employee e = new Employee();
        e.eat();
        s.sleep();
}
}