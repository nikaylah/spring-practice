package com.learn.model;

public class Author {
	private String authorId;
	private String name;
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author(String authorId, String name) {
		super();
		this.authorId = authorId;
		this.name = name;
	}
	
	public Author() {
		
	}

}
