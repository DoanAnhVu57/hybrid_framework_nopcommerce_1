package javaOOP;

public class Topic_05_This_Super {

	private int firtsNumber;
	private int secondNumber;
	
	public Topic_05_This_Super(int firtsNumber, int secondNumber) {
		this.firtsNumber = firtsNumber;
		this.secondNumber = secondNumber;
	}
	
	public void sumNumber() {
		System.out.println(this.firtsNumber + this.secondNumber );
	}
	
	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super(16, 7);
        topic.sumNumber();
	}

}
