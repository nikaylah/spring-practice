package com.learn.controller;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.learn.service.BookService;
import com.learn.exception.BookAlreadyExistsException;
import com.learn.exception.BookNotFoundException;
//http://localhost:9002/books - Post 
/*
{
 "isbn" : "1",
 "title" : "ram",
 "year" : 2019,
 "author" : {
     "authorId" :"a1",
     "name" : "ravi"
 }
}
*/
//http://localhost:9002/books/2 - GET
import com.learn.model.Book;
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) throws BookAlreadyExistsException  {
        ResponseEntity<?> responseEntity = null;
        try {
            Book addedBook = bookService.addBook(book);
            System.out.println("********Added Book :" + addedBook);
            if(addedBook != null) {
                responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
            }else {
                responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            
        } catch (BookAlreadyExistsException e) {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        return responseEntity;
    }
    
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBook(@PathVariable("bookId") String bookId) {
        ResponseEntity<?> responseEntity = null;
        try {
            Book book = bookService.getBook(bookId);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (BookNotFoundException e) {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            e.printStackTrace();
        }
        return responseEntity;
    }
     
 }
    /*@DeleteMapping("/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable("bookId") String bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }*/
    //Create a controller method to get all the books published in a given year
    //Use Query Parameter to pass the year
    //sample url from client
    // GET    /books?year=2018
    // GET /books?year=2019