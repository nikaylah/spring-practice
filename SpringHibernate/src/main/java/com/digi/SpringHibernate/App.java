package com.digi.SpringHibernate;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ax = new ClassPathXmlApplicationContext("Beans.xml");
		CustomerDAO cd = ax.getBean("customerDAO", CustomerDAO.class);
		
		CustomerDet c = new CustomerDet();
		c.setName("ram");
		c.setAddress("bng");
		cd.saveCustomer(c);
		
		List<CustomerDet> c1 = cd.getCustomerDetails();
		for(CustomerDet l : c1){
			System.out.println(l.getName() + "," + l.getAddress());
		}

	}

}