package com.studentinfosystem.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentinfosystem.model.*;
import com.studentinfosystem.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.*;

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

	@ApiOperation(value="View All Students", notes = "note")
	@GetMapping("/student/all") 
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}

	@GetMapping("/student/address/{studentId}") 
	public List<StudentAddress> getStudentAddress(@PathVariable String studentId) {
		return studentService.getStudentAddress(studentId);		
	}
	
	@GetMapping("/student/state/{stateName}") 
	public List<Student> getStudentsFromState(@PathVariable String stateName){
		return studentService.getStudentsFromState(stateName);
	}
	
	@GetMapping("/student/pincode/{pinCode}")
	public List<Student> getStudentsFromPinCode(@PathVariable String pinCode){
		return studentService.getStudentsFromSamePinCode(pinCode);
	}
	@GetMapping("/student/city/{cityName}")
	public List<Student> getStudentFromSameCity(@PathVariable String cityName){
		return studentService.getStudentFromSameCity(cityName);
	}

	@GetMapping("/student/course/all")
	public List<Course> getAllCourses(){
		return studentService.getAllCourses();
	}

	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable String studentId){
		return studentService.getStudent(studentId);
	}

	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId,
			@PathVariable String courseId) {
		return studentService.getCourse(studentId, courseId);
	}

	@GetMapping("/student/course/assinged/all")
	public List<Course> getAllAssignedCourses(){
		return studentService.getAllCoursesAssgined();
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
