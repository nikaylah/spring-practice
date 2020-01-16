package com.mongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Student;


public interface StudentRepository extends MongoRepository<Student, String> {
	//Optional<Student> findById(Spring studentId);
}
