package com.digi.model;

import java.time.LocalDate;

public class Contact {
	
	private int contactId;
	private String contactName;
	private String category;
	private LocalDate createdDate;
	
	public Contact() {
		
	}

	public Contact(int contactId, String contactName, String category, LocalDate createdDate) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.category = category;
		this.createdDate = createdDate;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	

	
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
