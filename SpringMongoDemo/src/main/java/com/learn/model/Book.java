package com.learn.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "mybooks")
public class Book {

	@Id
	private String isbn;
	
	@JsonProperty("bookTitle")
	private String title;
	private int year;
	private Author author;
	
	public Book() {}

	public Book(String isbn, String title, int year, Author author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}