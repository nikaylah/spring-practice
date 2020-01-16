package com.example.demo;

public class Customer {
	
	private int custId;
	private String name;
	private String address;
	
	public Customer() {
		super();
	}

	public Customer(int custId, String name, String address) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
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
	
	
	
	

}
