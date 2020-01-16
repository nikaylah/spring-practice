package com.digi.controller;


import com.digi.model.*;
import com.digi.dao.EmployeeDaoImpl;


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

@Controller
public class EmployeeController {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    //Contact contact = ctx.getBean(Contact.class);
    EmployeeDaoImpl dao = ctx.getBean(EmployeeDaoImpl.class);
    @GetMapping(path = { "/showEmployee" })
    public String showEmployees(ModelMap model) {
        List<Employee> employee = dao.getEmployees();
        model.addAttribute("employees", employee);
        return "employees";
    }
    
    @RequestMapping(path = "/saveEmployee", method = RequestMethod.POST) //PostMapping("/saveEmployee")
    public String saveEmployeeOld(@RequestParam("employeeId") Integer employeeId,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName, 
                              @RequestParam("city")String city,  
                              @RequestParam("state")String state){ 
        //Get the data from the form and create a contact object
        Employee employee = ctx.getBean(Employee.class);
        employee.setEmployeeId(employeeId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        Address address = ctx.getBean(Address.class);  
        address.setCity(city); 
        address.setState(state);
        employee.setAddress(address);
        //Save the contact in arraylist
        dao.addEmployee(employee);
        //redirect to showContacts
        return "redirect:showEmployees";
    }
    
    @GetMapping("/saveEmployee") //
    public String saveEmployeeNew(@ModelAttribute Employee employee) {
        //Save the contact in arraylist
        dao.addEmployee(employee);
        //redirect to showContacts
        return "redirect:showEmployees";
    }

	
}
