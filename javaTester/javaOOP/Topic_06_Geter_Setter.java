package javaOOP;

public class Topic_06_Geter_Setter {
	// Kiểm tra/ validate dữ liệu
    String personName;
    int personAge;
    private int personPhone;
    
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Tên nhập vào không được bỏ trống.");
		}else {
			this.personName = personName;
		}
	}
	
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		if (personAge > 0 && personAge < 110) {
			throw new IllegalArgumentException("Tuổi nhập vào không hợp lệ.");
		}else {
			this.personAge = personAge;
		}
	}
	
	public float getPersonPhone() {
		return personPhone;
	}
	
	public void setPersonPhone(int personPhone) {
		if (! String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thọa bắt đầu bằng: 09, 012,08");
		}else if (personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Số điện thoại phải có 10-11 số.");
		}else 
			this.personPhone = personPhone;
	}
   
}
