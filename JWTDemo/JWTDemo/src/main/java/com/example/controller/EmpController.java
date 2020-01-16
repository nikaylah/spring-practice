package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/emp")
public class EmpController {

	@GetMapping("/")
	public ResponseEntity<?> getEmp() {
		return new ResponseEntity<String>("Default Page",HttpStatus.OK);
	}
}
