package com.mongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.exception.StudentNotFoundException;
import com.mongo.exception.StudentAlreadyExistsException;
import com.mongo.exception.StudentNotFoundException;
import com.mongo.model.Student;
import com.mongo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) throws StudentAlreadyExistsException{
		Optional<Student> optStudent = studentRepository.findById(student.getStudentId());
		
		if(optStudent.isPresent()) {
			throw new StudentAlreadyExistsException("Student Already Exists");
		}
		Student saved = studentRepository.save(student);
		return saved;
	}

	@Override
	public Student getStudent(String studentId) throws StudentNotFoundException {

		System.out.println("******Student Service got executed");
		Student student = null;
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		if (studentOptional.isPresent()) {
			student = studentOptional.get();
			
		}else {
			throw new StudentNotFoundException("Student Does not exist");
			
		}
		return student;
	}

	@Override
	public boolean deleteStudent(String studentId) {
		// TODO Auto-generated method stub
		return false;
	}

}
