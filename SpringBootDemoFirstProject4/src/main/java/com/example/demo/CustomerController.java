package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class CustomerController {
	
	
	public List<Customer> getCustomerDetails(){

		List<Customer> cList = new ArrayList<Customer>();
		cList.add(new Customer(1, "Nikaylah" , "bng"));
		cList.add(new Customer(2, "Amy" , "abc"));
		cList.add(new Customer(3, "Alicia" , "efg"));
		
		return cList;
	}

	@GetMapping("/custdetails")
	public String listCustomerDetails(Model model) {
		model.addAttribute("clist", getCustomerDetails());
		return "cust";
	}
}
