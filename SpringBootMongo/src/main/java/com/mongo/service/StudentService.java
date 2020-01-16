package com.mongo.service;

import com.mongo.model.Student;

import com.mongo.exception.StudentAlreadyExistsException;
import com.mongo.exception.StudentNotFoundException;

public interface StudentService {
	
	Student addStudent(Student student) throws StudentAlreadyExistsException ;
	
	Student getStudent(String studentId) throws StudentNotFoundException;
	
	boolean deleteStudent(String studentId);

}
