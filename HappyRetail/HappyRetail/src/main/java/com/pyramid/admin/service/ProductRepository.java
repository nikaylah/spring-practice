package com.pyramid.admin.service;

import com.pyramid.admin.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
