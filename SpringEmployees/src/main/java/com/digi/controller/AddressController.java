package com.digi.controller;
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
    //description description = ctx.getBean(description.class);
    descriptionDaoImpl dao = ctx.getBean(descriptionDaoImpl.class);
    @GetMapping(path = { "/showdescriptiones" })
    public String showAlldescriptiones(ModelMap model) {
        List<description> descriptiones = dao.getdescriptiones();
        model.addAttribute("descriptiones", descriptiones);
        return "descriptiones";
    }
    
    @RequestMapping(path = "/savedescription", method = RequestMethod.POST) //PostMapping("/savedescription")
    public String savedescriptionOld(@RequestParam("descriptionId") Integer id,
                              @RequestParam("street") String street,
                              @RequestParam("city") String city,
    						@RequestParam("state") String state,
    						@RequestParam("country") String country)									{
        //Get the data from the form and create a description object
        description description = ctx.getBean(description.class);
        description.setdescriptionId(id);
        description.setStreet(street);
        description.setCity(city);
        description.setState(state);
        description.setCountry(country);
        //Save the contact in arraylist
        dao.adddescription(description);
        //redirect to showdescriptiones
        return "redirect:showdescriptiones";
    }
    
    @GetMapping("/savedescription") //
    public String savedescriptionNew(@ModelAttribute description description) {
        //Save the contact in arraylist
        dao.adddescription(description);
        //redirect to showdescriptiones
        return "redirect:showdescriptiones";
    }
}
