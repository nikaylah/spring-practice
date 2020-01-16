package com.pyramid.admin.controller;

import com.pyramid.admin.model.Category;
import com.pyramid.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryService cs;

    @RequestMapping("/addCategory")
    public void addCategory(@RequestParam("name") String name,
                            HttpServletResponse response) throws IOException {
        cs.addCategory(new Category(name));
        response.sendRedirect("showCategories");
    }

    @RequestMapping("/updateCategory")
    public void updateCategory(@RequestParam("categoryId") int id,
                               @RequestParam("name") String name,
                            HttpServletResponse response) throws IOException {
        cs.addCategory(new Category(id, name));
        response.sendRedirect("showCategories");
    }

    @RequestMapping("/deleteCategory")
    public void deleteCategory(@RequestParam("categoryId") int id,
                            HttpServletResponse response) throws IOException {
        cs.deleteCategory(id);
        response.sendRedirect("showCategories");
    }
}
