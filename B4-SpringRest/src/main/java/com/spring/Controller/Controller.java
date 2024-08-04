package com.spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@GetMapping("/courses")
	public String home() {
		
		return "Welcome to courses application";
	
	}

}
