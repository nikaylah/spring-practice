package com.digi.SpringJdbcHomework1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account1")
public class AccountDet {
	
	
	@Id
	private int account_id;
	private String name;
	private String address;
	private String age;
	private String city;
	private String identity;
	
	public AccountDet() {
		super();
	}

	public AccountDet(int account_id, String name, String address, String age, String city, String identity) {
		super();
		this.account_id = account_id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.city = city;
		this.identity = identity;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
}
