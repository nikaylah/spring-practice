package com.pyramid.admin.service;

import com.pyramid.admin.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
