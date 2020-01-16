package com.learn.service;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.exception.BookAlreadyExistsException;
import com.learn.exception.BookNotFoundException;
//import com.learn.exception.BookAlreadyExistsException; 
//import com.learn.exception.BookNotFoundException;
import com.learn.model.Book;
import com.learn.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;	
	
	@Override
	public Book addBook(Book book) throws BookAlreadyExistsException {
		Optional<Book> optBook = bookRepository.findById(book.getIsbn());

		if (optBook.isPresent()) {
			throw new BookAlreadyExistsException("Book Already Exists");
		}
		Book saved = bookRepository.save(book);
		return saved;
		
	}

	@Override
	public Book getBook(String bookId) throws BookNotFoundException {
		
		System.out.println("***********Book Service got executed");
		Book book = null;
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		if (bookOptional.isPresent()) {
			 book = bookOptional.get();
		}else {
			throw new BookNotFoundException("Book Does not exist");
		}
		return book;
	}

	@Override
	public boolean deleteBook(String bookId) {
		// TODO Auto-generated method stub
		return false;
	}
}