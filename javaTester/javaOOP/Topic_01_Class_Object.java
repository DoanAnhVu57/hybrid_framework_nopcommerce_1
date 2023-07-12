package javaOOP;

import net.bytebuddy.asm.Advice.This;

public class Topic_01_Class_Object {
	private int studentID;
	private String studentName;
	private Float knowlegdePoint;
	private Float practicePoint;

	private final int getStudentID() {
		return studentID;
	}

	private final void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private final String getStudentName() {
		return studentName;
	}

	private final void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private final Float getKnowlegdePoint() {
		return knowlegdePoint;
	}

	private final void setKnowlegdePoint(Float knowlegdePoint) {
		this.knowlegdePoint = knowlegdePoint;
	}

	private final Float getPracticePoint() {
		return practicePoint;
	}

	private final void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	private Float getAveragePoint() {
		return (this.knowlegdePoint + this.practicePoint * 2)/3;
		
	}
	
	private void showStudentInfor() {
		System.out.println("*************");
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student Name" + getStudentName());
		System.out.println("Student knowlegde Point" + getKnowlegdePoint());
		System.out.println("Student practice Point;" + getPracticePoint());
		System.out.println("Student Average Point;" + getAveragePoint());
	}

	public static void main(String[] args) {
		Topic_01_Class_Object firtsStudent = new Topic_01_Class_Object();
		firtsStudent.setStudentID(206667);
		firtsStudent.setStudentName("John Terry");
		firtsStudent.setKnowlegdePoint(7.0f);
		firtsStudent.setPracticePoint(8.0f);
		firtsStudent.showStudentInfor();
	
	Topic_01_Class_Object secondStudent = new Topic_01_Class_Object();
	secondStudent.setStudentID(206664);
	secondStudent.setStudentName("May");
	secondStudent.setKnowlegdePoint(7.0f);
	secondStudent.setPracticePoint(8.0f);
	secondStudent.showStudentInfor();
}


}
