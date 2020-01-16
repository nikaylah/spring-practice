package com.pyramid.admin.service;

import com.pyramid.admin.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository cr;

    public List<Category> getCategories(){
        List<Category> list = new ArrayList<>();
        cr.findAll().forEach(list::add);
        list.sort(Category::compareTo);
        return list;
    }

    public Category findCategoryById(int id){
        return cr.findById(id).orElse(new Category("Other"));
    }

    public void addCategory(Category c){
        cr.save(c);
    }

    public boolean deleteCategory(int id){
        if (cr.existsById(id)) {
            cr.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
