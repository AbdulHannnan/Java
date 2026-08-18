package com.crudAPI.REST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String home() {
		return "REST API is running on port 8081";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Spring Boot!";
	}
}
