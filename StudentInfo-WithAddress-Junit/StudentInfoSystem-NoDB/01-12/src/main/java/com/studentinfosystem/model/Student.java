package com.studentinfosystem.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@Entity
@ApiModel(description ="All Student Info Details.")
public class Student {
	@Id
	@GeneratedValue
	@ApiModelProperty(notes="houseNumber")
	@Size(min=2, message="Name Should be string.")
	private String studentID;
	@ApiModelProperty(notes="Student Name")
	private String studentName;
	@ApiModelProperty(notes="sAddress")
	private String studentDescription;
	@ApiModelProperty(notes="courses")
	private List<Course> courses;
	@ApiModelProperty(notes="sAddress")
	private List<StudentAddress> sAddress;
	private List<Fee> fee;

	public Student() {
	}

	public Student(String studentID, List<StudentAddress> sAddress) {
		this.studentID = studentID;
		this.sAddress = sAddress;
	}

	public Student(String studentID, String studentName, List<StudentAddress> sAddress, String studentDescription, List<Course> courses, List<Fee> fee) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.sAddress = sAddress;
		this.studentDescription = studentDescription;
		this.courses = courses;
		this.fee=fee;
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

	public List<Fee> getFee() {
		return fee;
	}

	public void setFee(List<Fee> fee) {
		this.fee = fee;
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
