package com.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.exception.UserExistsException;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		ResponseEntity<?> response = null;
		try {
			userService.registerUser(user);
			response = new ResponseEntity<String>(HttpStatus.OK);
		}
		catch(UserExistsException u) {
			response = new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		catch(Exception e) {
			response = new ResponseEntity<String>
					(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) 
			throws UserNotFoundException {
		User validUser = 
				userService.login(user.getUsername(), user.getPassword());
		if(validUser == null) {
			throw new UserNotFoundException();
		}
		String token = Jwts.builder().setId(validUser.getUsername())
				.setSubject(validUser.getRole()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "userkey").compact();
		Map<String,String> m = new HashMap<String,String>();
		m.put("token", token);
		m.put("message", "User valid");
		ResponseEntity<Map<String,String>> response = 
				new ResponseEntity<Map<String,String>>(HttpStatus.OK);
		return response;
	}
}
