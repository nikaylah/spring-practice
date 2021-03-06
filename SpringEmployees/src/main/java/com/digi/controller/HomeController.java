package com.digi.controller;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
//Used for creating a controller bean by spring
@Controller
public class HomeController {
    
    //Used for mapping HttpRequest url and Httpmethod
    //to a controller method
    @GetMapping(path = {"/home","/","/homep"})
    public String homePage(Model model) {
        //adding a key value pair in model for sending data
        model.addAttribute("message", "Welcome to Spring MVC");
        model.addAttribute("today", new Date());
        //logical view name
        //Actual from view resolver - /WEB-INF/views/index.jsp
        return "index";
    }
    
    @GetMapping("/adddescriptionForm")
    public ModelAndView  adddescriptionForm() {
        ModelAndView model = new ModelAndView("adddescriptionform");
        model.addObject("message", "Page to display new description form");
        return model;
    }
}