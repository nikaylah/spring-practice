package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	@GetMapping("/api/v1/emp")
	public ResponseEntity<?> getEmp(){
		return new ResponseEntity<String>("Default page", HttpStatus.OK);
	}

}
