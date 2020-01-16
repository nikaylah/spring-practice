package com.pyramid.admin.controller;

import com.pyramid.admin.model.Product;
import com.pyramid.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    ProductService ps;

    @RequestMapping("/addProduct")
    public void addProduct(@RequestParam("name") String name,
                            @RequestParam("description") String description,
                            @RequestParam("price") double price,
                            @RequestParam("category") int category,
                            HttpServletResponse response) throws IOException {
        ps.addProduct(new Product(name, description, price, category));
        response.sendRedirect("showProducts");
    }

    @RequestMapping("/deleteProduct")
    public void deleteProduct(@RequestParam("productId") int id,
                               HttpServletResponse response) throws IOException {
        ps.deleteProduct(id);
        response.sendRedirect("showProducts");
    }
}
