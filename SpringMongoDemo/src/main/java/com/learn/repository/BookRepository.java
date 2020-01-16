package com.learn.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
	List<Book> findByTitle(String title);

}
