package com.digi.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digi.dao.descriptionDaoImpl;
import com.digi.dao.EmployeeDaoImpl;
import com.digi.model.description;
import com.digi.model.Employee;

@Controller
public class EmployeeController {
	ApplicationContext emp = new ClassPathXmlApplicationContext("beans.xml");
	EmployeeDaoImpl dao = emp.getBean(EmployeeDaoImpl.class);
	
	@GetMapping(path = {"/showEmployee"})
	public String showAllEmployees(ModelMap model) {
		List<Employee> employee = dao.getEmployee();
		model.addAttribute("employeess" , employee);
		return "employeess";
	}
	
    @RequestMapping(path = "/saveEmployee", method = RequestMethod.POST) //PostMapping("/savedescription")
    public String saveEmployeeOld(@RequestParam("employeeId") Integer employeeid,
                              @RequestParam("firstName") String firstname,
                              @RequestParam("lastName") String lastname,
    						@RequestParam("category") String category)									{
        //Get the data from the form and create a description object
        Employee employee = emp.getBean(Employee.class);
        employee.setEmployeeId(employeeid);
        employee.setFirstName(firstname);
        employee.setLastName(lastname);
        employee.setCategory(category);
        
        //Save the contact in arraylist
        dao.addEmployee(employee);
        //redirect to showdescriptiones
        return "redirect:showEmployee";
        
    
    }
    
    @GetMapping("/saveEmployee") //
    public String saveEmployeeNew(@ModelAttribute Employee employee) {
        //Save the contact in arraylist
        dao.addEmployee(employee);
        //redirect to showdescriptiones
        return "redirect:showEmployee";
    }
	
}
