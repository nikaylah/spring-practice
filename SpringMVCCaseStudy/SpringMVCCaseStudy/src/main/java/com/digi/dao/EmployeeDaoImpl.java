package com.digi.dao;


import java.util.List;  
import java.util.ArrayList;

import com.digi.model.Address;
import com.digi.model.Employee;

public class EmployeeDaoImpl {  
	private List<Employee> employees; 
	
	public EmployeeDaoImpl() {
		this.employees = new ArrayList<Employee>(); 
		employees.add(new Employee(1, "Mark", "Amechi", new Address("Atlanta", "Georgia"))); 
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

}
