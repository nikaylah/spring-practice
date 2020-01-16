package com.pyramid.admin.service;

import com.pyramid.admin.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public List<Product> getProducts(){
        List<Product> list = new ArrayList<>();
        pr.findAll().forEach(list::add);
        list.sort(Product::compareTo);
        return list;
    }

    public void addProduct(Product p){
        pr.save(p);
    }

    public boolean deleteProduct(int id){
        if (pr.existsById(id)) {
            pr.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
