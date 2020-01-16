package com.digi.dao;
import java.time.LocalDate;
import java.util.*;

import com.digi.model.Contact;


public class ContactDaoImpl {
	
	private List<Contact> contacts;
	
	public ContactDaoImpl() {
		this.contacts = new ArrayList<Contact>();
		contacts.add(new Contact(1, "Hello", "Personal", LocalDate.now()));
	}
		

	public List<Contact> getContacts() {
			return contacts;
		}
		
	public void setContacts(List<Contact> contacts) {
			this.contacts = contacts;
		}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
