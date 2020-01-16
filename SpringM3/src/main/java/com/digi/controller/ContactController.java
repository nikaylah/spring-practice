package com.digi.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.digi.dao.ContactDaoImpl;
import com.digi.model.Contact;

@Controller
public class ContactController {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	// Contact contact = ctx.getBean(Contact.class);
	ContactDaoImpl dao = ctx.getBean(ContactDaoImpl.class);

	@GetMapping(path = { "/showContacts" })
	public String showAllContacts(ModelMap model) {
		List<Contact> contacts = dao.getContacts();
		model.addAttribute("contacts", contacts);
		return "contacts";
	}

	@RequestMapping(path = "/saveContact", method = RequestMethod.POST) // PostMapping("/saveContact")
	public String saveContactOld(@RequestParam("contactId") Integer id, @RequestParam("contactName") String name,
			@RequestParam("category") String category) {
		// Get the data from the form and create a contact object
		Contact contact = ctx.getBean(Contact.class);
		contact.setContactId(id);
		contact.setContactName(name);
		contact.setCategory(category);
		contact.setCreatedDate(LocalDate.now());
		// Save the contact in arraylist
		dao.addContact(contact);
		// redirect to showContacts
		return "redirect:showContacts";
	}

	@GetMapping("/saveContact") //
	public String saveContactNew(@ModelAttribute Contact contact) {
		contact.setCreatedDate(LocalDate.now());
		// Save the contact in arraylist
		dao.addContact(contact);
		// redirect to showContacts
		return "redirect:showContacts";
	}
}
