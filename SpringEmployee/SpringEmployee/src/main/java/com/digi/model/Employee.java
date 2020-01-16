package com.digi.model;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private description description;
	
	public Employee(int employeeId, String firstName, String lastName, description description) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public description getdescription() {
		return description;
	}

	public void setdescription(description description) {
		this.description = description;
	}
	
}
