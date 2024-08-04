package com.spring.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.service.courseService;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	

	@Autowired
	private courseService courceService1;
	
	
	@GetMapping("/home")
	public String home() {
		
		return "Hello welcome to my Courses App";
	}
	
	

	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courceService1.getCourses();
		
	}
	

}
