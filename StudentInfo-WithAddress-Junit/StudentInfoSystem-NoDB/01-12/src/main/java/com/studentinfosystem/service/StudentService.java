package com.studentinfosystem.service;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.studentinfosystem.model.*;

@Component
public class StudentService {

	private static List<Student> students = new ArrayList<>();
	private static List<Course> courses = new ArrayList<>();
	private static List<StudentAddress> address = new ArrayList<>();
	private static List<Fee> fees = new ArrayList<>();

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

		Fee fee1 = new Fee(1000, 100, 100, 100);
		Fee fee2 = new Fee(2000, 200, 200, 200);
		Fee fee3 = new Fee(3000, 300, 300, 300);
		
		Student s1 = new Student("Student1", "Ranga Karanam", Arrays.asList(address1), "Hiker, Programmer and Architect", 
				new ArrayList<>(Arrays.asList(course1, course2)), Arrays.asList(fee1));

		Student s2 = new Student("Student2", "Satish T",Arrays.asList(address2),"Hiker, Programmer and Architect",
				new ArrayList<>(Arrays.asList(course3, course4)), Arrays.asList(fee2));

		Student s3 = new Student("Student3","sams", Arrays.asList(address3), "collection",
				new ArrayList<>(Arrays.asList(course3, course4)), Arrays.asList(fee3));

		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
		
		address.add(address1);
		address.add(address2);
		address.add(address3);
		
		fees.add(fee1);
		fees.add(fee3);
		fees.add(fee3);
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
	}

	public List<Student> getAllStudents(){
		return students;
	}

	public List<Course> getAllCourses(){
		return courses;
	}

	public List<StudentAddress> getStudentAddress(String studentID) {
		Student student = getStudent(studentID);
		List<StudentAddress> address = student.getsAddress();
		return address;
	}

	public List<Student> getStudentsFromState(String stateName) {
		ListIterator<Student> lt = students.listIterator();
		List<Student> stateStudents = new ArrayList<>();
		while(lt.hasNext()) {
			Student student = lt.next();
			List<StudentAddress> address = student.getsAddress();
			for (int i=0;i<address.size();i++) {				
				if(address.get(i).getState().equals(stateName)){
					stateStudents.add(student);
				}
			}
		}
			
		return stateStudents;
	}
	
	
	public List<Student> getStudentsFromSamePinCode(String pinCode){
		ListIterator<Student> lt = students.listIterator();
		List<Student> subStudents = new ArrayList<>();
		while(lt.hasNext()) {
			Student student = lt.next();
			List<StudentAddress>address = student.getsAddress();
			for(int i=0;i<address.size();i++) {
				if(address.get(i).getpinCode().equals(pinCode))
					subStudents.add(student);
			}
		}
		return subStudents;
	}
	
	public List<Student> getStudentFromSameCity(String cityName){
		ListIterator<Student> lt = students.listIterator();
		List<Student> subStudent = new ArrayList<>();
		while(lt.hasNext()) {
			Student student = lt.next();
			List<StudentAddress> address = student.getsAddress();
			for(int i=0;i<address.size();i++) {
				if(address.get(i).getCityName().equals(cityName)){
					subStudent.add(student);
				}
			}
		}
		return subStudent;
	}
	
	public List<Student> getStudentsUsingPinCode(String pinCode) {
		return students;
	}
	
	public List<StudentAddress> getAllStudentAddress(){
		return	address;
	}

	public List<Course> getAllCoursesAssgined(){
		ListIterator<Student> it = students.listIterator();
		while(it.hasNext()) {
			Student st = it.next();		
			return st.getCourses();
		}
		return null;
	}

	public Student getStudent(String studentID) {
		for(Student student : students) {
			if(student.getStudentID().equals(studentID)) {
				return student;
			}
		}
		return null;
	}

	public List<Course> getCourses(String studentID) {
		Student student = getStudent(studentID);
		if(student == null) {
			return null;
		}
		return student.getCourses();
	}

	public Course getCourse(String studentID, String courseID) {
		Student student = getStudent(studentID);
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
