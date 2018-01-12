package com.studentinfosystem.model;

import java.util.*;

import org.apache.tomcat.jni.Address;


public class Student {
	
	private String studentID;
	private String studentName;
	private String studentDescription;
	private List<Course> courses;
	private List<StudentAddress> sAddress;
		
	public Student() {
	}
	
	public Student(String studentID, List<StudentAddress> sAddress) {
		this.studentID = studentID;
		this.sAddress = sAddress;
	}

	public Student(String studentID, String studentName, List<StudentAddress> sAddress, String studentDescription, List<Course> courses) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.sAddress = sAddress;
		this.studentDescription = studentDescription;
		this.courses = courses;
	}
	
	public List<StudentAddress> getsAddress() {
		return sAddress;
	}

	public void setsAddress(List<StudentAddress> sAddress) {
		this.sAddress = sAddress;
	}

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}
	
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	public String getStudentDescription() {
		return studentDescription;
	}
	
	
	public void setStudentDescription(String studentDescription) {
		this.studentDescription = studentDescription;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public String showAddress(){
		Student s = new Student();
		List<StudentAddress> address;
		address = s.getsAddress(); 
		return String.format("SteetName: %s", "Apt No: %s, City: %s, Pin: %s", address.get(1), address.get(2), address.get(3), address.get(4));		
	}
	

	@Override
	public String toString() {
		return String.format("Cource [studentID= %s, studentName= %s, studentDescription=%d, studentSteps=%s]"
				,studentID, studentName, studentDescription, courses);
	}
	

}
