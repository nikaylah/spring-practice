package com.pyramid.admin.model;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category implements Comparable<Category> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
    @SequenceGenerator(name="category_generator", sequenceName = "category_seq")
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "name", length = 15)
    private String name;

    public Category(){}
    public Category(String name) {
        this.name = name;
    }
    public Category(int categoryId, String name){
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Category c) {
        if (categoryId > c.getCategoryId()){
            return 1;
        } else if (categoryId < c.getCategoryId()){
            return -1;
        } else { return 0; }
    }
}
