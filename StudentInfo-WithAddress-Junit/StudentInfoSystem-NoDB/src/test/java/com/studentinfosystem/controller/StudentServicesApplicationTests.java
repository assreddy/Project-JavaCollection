package com.studentinfosystem.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.studentinfosystem.model.Course;
import com.studentinfosystem.model.Student;
import com.studentinfosystem.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=StudentInfoController.class,secure=false)
public class StudentServicesApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StudentService studentService;
	
	Course mockCourse = new Course("Course1", "Spring", "10Steps",
			Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
	@Test
	public void retrieveDetailsForCourse() throws Exception{
		Mockito.when(studentService.retriveCourse(Mockito.anyString(),Mockito.anyString())).thenReturn(mockCourse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/Student1/courses/Course1").accept(MediaType.APPLICATION_JSON);
		MvcResult restult = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Resoponse" +restult.getResponse());
		
		String expected = "{courseID:Course1, courseName:Spring, courseDescription:10Steps}";
		JSONAssert.assertEquals(expected, restult.getResponse().getContentAsString(), false);
	}
}
