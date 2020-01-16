package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LoginPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginPracticeApplication.class, args);
	}
	
	
	@RestController
	class FormController {
		@GetMapping("/everyone")
		String getEveryone() {
			return "Hello everyone!";
		}
		
		@GetMapping("/admin")
		String adminOnly() {
			return "<h1>Administrator Page <h1> Greetings Admin!";
		}
	}

}
