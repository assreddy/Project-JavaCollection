package com.studentinfosystem.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studentinfosystem.model.*;
import com.studentinfosystem.service.StudentService;

@RestController
@RequestMapping("/studentinfo")
public class StudentInfoController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET,
			value ="healthcheck")
	public String index() {
		return "School info no DB";
	}
	
	@GetMapping("/student/all") 
	public List<Student> getAllStudents(){
		return studentService.retriveAllStudents();
	}
	
	@GetMapping("/student/address/{studentId}") 
	public List<StudentAddress> retriveStudentAddress(@PathVariable String studentId) {
		return studentService.getStudentAddress(studentId);		
	}
	
	@GetMapping("student/course/all")
	public List<Course> getAllCourses(){
		return studentService.retriveAllCourses();
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable String studentId){
		return studentService.retriveStudent(studentId);
	}
	
	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId,
			@PathVariable String courseId) {
		return studentService.retriveCourse(studentId, courseId);
	}
	
	@GetMapping("/student/course/assinged/all")
	public List<Course> getAllAssignedCourses(){
		return studentService.retriveAllCoursesAssgined();
	}
	
	public String addStudent(){
		return "pass";		 
	}
	
	public String postStudent() {
		return "pass";
	}
	
	public String deleteStudent() {
		return "pass";
	}
	
	public String putStudent() {
		return "pass";
	}
	
}
