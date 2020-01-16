package com.mongo.model;
import com.mongo.model.Course;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;


@Document(collection = "mystudent")
public class Student {
	
	@Id
	private String studentId;
	
	@JsonProperty("studentName")
	private String name;
	private Course course;
	private String address;
	
	public Student(String studentId, String name, Course course, String address) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.course = course;
		this.address = address;
	
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Student() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
