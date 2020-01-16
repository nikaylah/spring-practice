package com.pyramid;

import com.pyramid.admin.model.Category;
import com.pyramid.admin.model.Product;
import com.pyramid.admin.service.CategoryService;
import com.pyramid.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CategoryService cs;
    @Autowired
    ProductService ps;

    @RequestMapping("")
    public String adminPortal(){
        return "adminportal";
    }

    @RequestMapping("/showCategories")
    public String showAllCategories(ModelMap model) {
        List<Category> categories = cs.getCategories();
        model.addAttribute("categories", categories);
        return "category";
    }

    @RequestMapping("/showProducts")
    public String showAllProducts(ModelMap model) {
        List<Category> categories = cs.getCategories();
        List<Product> products = ps.getProducts();
        products.forEach(p -> p.setCategory(cs.findCategoryById(p.getCategoryId()).getName()));
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "product";
    }
}
