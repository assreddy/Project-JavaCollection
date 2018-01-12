package com.studentinfosystem.service;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.studentinfosystem.model.*;

@Component
public class StudentService {
	
	private static List<Student> students = new ArrayList<>();
	private static List<Course> courses = new ArrayList<>();

	
	static{
		
		Course course1 = new Course("Course1", "Spring", "10Steps", Arrays
				.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Course course2 = new Course("Course2", "Spring MVC", "10Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Course course3 = new Course("Course3", "Spring Boot", "6KStudents",
				Arrays.asList("Learn Maven", "Learn Spring",
						"Learn Spring MVC", "First Example", "SecondExample"));
		Course course4 = new Course("Course4", "Maven", "Internet!", 
				Arrays.asList("Pom.xml", "Build Life Cycle", "Parent POM","Importing into Eclipse"));
		
		StudentAddress address1 = new StudentAddress("100","St1","apt1","City1","94087", "GA");
		StudentAddress address2 = new StudentAddress("200","St2","apt2","City2","94087", "PA");
		StudentAddress address3 = new StudentAddress("300","St3","apt3","City3","94087", "CA");
		

		Student s1 = new Student("Student1", "Ranga Karanam", new ArrayList<>(Arrays.asList(address1)), "Hiker, Programmer and Architect", 
				new ArrayList<>(Arrays.asList(course1, course2)));

		Student s2 = new Student("Student2", "Satish T",new ArrayList<>(Arrays.asList(address2)),"Hiker, Programmer and Architect",
				new ArrayList<>(Arrays.asList(course3, course4)));
		
		Student s3 = new Student("Student3","sams", new ArrayList<>(Arrays.asList(address3)), "collection",
				new ArrayList<>(Arrays.asList(course3, course4)));
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
	}
	
	public List<Student> retriveAllStudents(){
		return students;
	}
	
	public List<Course> retriveAllCourses(){
		return courses;
	}
	
	public List<StudentAddress> getStudentAddress(String studentID) {
		Student student = retriveStudent(studentID);
		List<StudentAddress> address = student.getsAddress();
		return address;
	}
	
	public List<Course> retriveAllCoursesAssgined(){
		ListIterator<Student> it = students.listIterator();
		while(it.hasNext()) {
			Student st = it.next();		
			return st.getCourses();
		}
		return null;
	}
		
	public Student retriveStudent(String studentID) {
		for(Student student : students) {
			if(student.getStudentID().equals(studentID)) {
				return student;
			}
		}
		return null;
		
	}
	
	public List<Course> retriveCourses(String studentID) {
		Student student = retriveStudent(studentID);
		if(student == null) {
			return null;
		}
		return student.getCourses();
	}
	
	public Course retriveCourse(String studentID, String courseID) {
		Student student = retriveStudent(studentID);
		if(student == null) {
			return null;
		}
		for (Course course : student.getCourses()) {
			if(course.getcourseID().equals(courseID)) {
				return course;
			}
		}
		return null;
	}
	
}
