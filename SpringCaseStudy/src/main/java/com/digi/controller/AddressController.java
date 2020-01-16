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
import com.digi.dao.descriptionDaoImpl;
import com.digi.model.description;

@Controller
public class descriptionController {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	// Contact contact = ctx.getBean(Contact.class);
	descriptionDaoImpl dao = ctx.getBean(descriptionDaoImpl.class);

	@GetMapping(path = { "/showdescription" })
	public String showAlldescription(ModelMap model) {
		List<description> descriptiones = dao.getdescriptiones();
		model.addAttribute("description", descriptiones);
		return "description";
	}

	@RequestMapping(path = "/savedescription", method = RequestMethod.POST) // PostMapping("/savedescription")
	public String savedescriptionOld(@RequestParam("descriptionId") Integer id, @RequestParam("descriptionName") String name,
			@RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("country") String country ) {
		// Get the data from the form and create a contact object
		description description = ctx.getBean(description.class);
		description.setdescriptionId(id);
		description.setdescriptionName(name);
		description.setCity(city);
		description.setState(state);
		description.setCountry(country);
		// Save the contact in arraylist
		dao.adddescription(description);
		// redirect to showContacts
		return "redirect:showdescription";
	}

	@GetMapping("/savedescription") //
	public String savedescriptionNew(@ModelAttribute description description) {
		//description.setCreatedDate(LocalDate.now());
		// Save the description in arraylist
		dao.adddescription(description);
		// redirect to showContacts
		return "redirect:showdescription";
	}
}
