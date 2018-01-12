package com.studentinfosystem.model;

import java.util.*;

public class Course {
	private String courseID;
	private String courseName;
	private String courseDescription;
	private List<String> courseSteps;
	
	public Course() {
	}
	
	public Course(String courseID, String courseName, String courseDescription, List<String> courseSteps) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseSteps = courseSteps;
	}
	
	public String getcourseID() {
		return courseID;
	}
	public void setcourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getcourseName() {
		return courseName;
	}
	public void setcourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getcourseDescription() {
		return courseDescription;
	}
	public void setcourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public List<String> getcourseSteps() {
		return courseSteps;
	}
	public void setcourseSteps(List<String> courseSteps) {
		this.courseSteps = courseSteps;
	}	
	
	@Override
	public String toString() {
		return String.format("course [courseID= %s, courseName= %s, courseDescription=%d, courseSteps=%s]"
				,courseID, courseName, courseDescription, courseSteps);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseID == null) ? 0 : courseID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseID == null) {
			if (other.courseID != null)
				return false;
		} else if (!courseID.equals(other.courseID))
			return false;
		return true;
	}


}
