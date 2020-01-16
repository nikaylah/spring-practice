package com.digi.SpringJdbcHomework1;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountDAO {
	
	
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveAccount(AccountDet c){
		Session ss = sessionFactory.openSession();
		Transaction t = ss.beginTransaction();   //starting transaction
		ss.persist(c);                           //saving record in the table (aka adding)
		t.commit();                              //changes will be commited to table
		ss.close();                              //closing
		
	}
	
	public void deleteAccount(AccountDet c){
		Session ss = sessionFactory.openSession();
		Transaction t = ss.beginTransaction();   //starting transaction
		ss.delete(c);                           //deleting record in the table (aka adding)
		t.commit();                              //changes will be commited to table
		ss.close();                              //closing
		
	}
	
	public void updateAccount(AccountDet c){
		Session ss = sessionFactory.openSession();
		Transaction t = ss.beginTransaction();   //starting transaction
		ss.update(c);                           //updating record in the table (aka adding)
		t.commit();                              //changes will be commited to table
		ss.close();                              //closing
		
	}

	public List<AccountDet>  getAccountDetails(){
		Session ss = sessionFactory.openSession();
		List<AccountDet> c = ss.createQuery("from AccountDet").list(); //fetching the record
		ss.close();
		return c;
	}



}
