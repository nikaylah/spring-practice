package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@PostMapping(path = "/customersave")
	public String getDetails(@RequestBody Customer customer)
	{
		return "Customer Details: " + customer.getCustId() + ","
				+ customer.getName() + ","
				+ customer.getAddress();
	}
	

}
