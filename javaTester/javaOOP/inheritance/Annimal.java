package javaOOP.inheritance;

public class Annimal {
    public Annimal() {
    	System.out.println("parent's constractor");
    }
    public Annimal(String name) {
    	System.out.println("parent's constractor" + name);
    }
    public Annimal(String name, String age) {
    	System.out.println("parent's constractor - " + name);
    	System.out.println("parent's constractor - "+ age);
    }
    
}
