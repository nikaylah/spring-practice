package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AccountTypeService {
	
	@Autowired
	private AccountTypeRepository ar;
	
	public void addAccountType(AccountType at) {
		ar.save(at);
	}
	
	public List<AccountType> getAccountTypeDetails(){
		List<AccountType> atlist = new ArrayList<>();//create a new array list
		ar.findAll().forEach(atlist::add); //forEach is a function, adding all the information into the list
		return atlist;
	}
	
	public int deleteAccountType(int id) {
		if(ar.existsById(id))
		{
			ar.deleteById(id);
			return 1;
		}
		else
			return 0;
	}

}
