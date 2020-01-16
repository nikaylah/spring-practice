package com.mongo.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.exception.StudentAlreadyExistsException;
import com.mongo.exception.StudentNotFoundException;
import com.mongo.exception.StudentAlreadyExistsException;
import com.mongo.exception.StudentNotFoundException;
import com.mongo.model.Student;
import com.mongo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody Student student) throws StudentAlreadyExistsException  {
	        ResponseEntity<?> responseEntity = null;
	        try {
	            Student addedStudent = studentService.addStudent(student);
	            System.out.println("********Added student :" + addedStudent);
	            if(addedStudent != null) {
	                responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
	            }else {
	                responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	            }
	            
	        } catch (StudentAlreadyExistsException e) {
	            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).build();
	        } catch (Exception e) {
	            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	        
	        return responseEntity;
	    }

	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudent(@PathVariable("studentId") String studentId) {
		ResponseEntity<?> responseEntity = null;
		try {
			Student student = studentService.getStudent(studentId);
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(student);
		} catch (StudentNotFoundException e) {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			e.printStackTrace();
		}
		return responseEntity;
	}

}
