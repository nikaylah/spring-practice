package com.learn.service;


import com.learn.exception.BookAlreadyExistsException;
import com.learn.exception.BookNotFoundException;
//import com.learn.exception.BookAlreadyExistsException;
//import com.learn.exception.BookNotFoundException;
import com.learn.model.Book;

public interface BookService {
	
	Book addBook(Book book) throws BookAlreadyExistsException ;
	
	Book getBook(String bookId) throws BookNotFoundException ;
	
	boolean deleteBook(String bookId) ;

}