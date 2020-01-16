package com.digi.dao;

import java.util.ArrayList;
import java.util.List;

import com.digi.model.description;
import com.digi.model.Employee;

public class EmployeeDaoImpl {

	private List<Employee>employees;
	
	
	public EmployeeDaoImpl() {
		this.employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Aly", "Zoom", "Teacher"));
	}
	
	public List<Employee> getEmployee(){
		return employees;
	}
	
	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
  	
}
