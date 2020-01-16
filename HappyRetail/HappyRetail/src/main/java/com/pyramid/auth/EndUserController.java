package com.pyramid.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class EndUserController {

    @Autowired
    EndUserService eus;

    @RequestMapping("/addUser")
    public void addUser(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role,
                        HttpServletResponse response) throws IOException {
        eus.addUser(new EndUser(username, password, role));
        response.sendRedirect("register");
    }
}
