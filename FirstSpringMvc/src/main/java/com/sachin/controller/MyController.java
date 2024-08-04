package com.sachin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/hello")
	public String displayHello() {
		
		return "welcome";
	}

}
