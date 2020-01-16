package com.pyramid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = {"/home","/","/homep"})
    public String homePage(Model model) {
        //adding a key value pair in model for sending data
        model.addAttribute("message", "Happy Retail");
        //Actual from view resolver - /WEB-INF/views/index.html
        return "index";
    }
}