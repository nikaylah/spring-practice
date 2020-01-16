package com.example.demo;

public class Dealer {
	
	private int dealerId;
	private String name;
	private String description;
	
	public Dealer() {
		super();
	}

	public Dealer(int dealerId, String name, String description) {
		super();
		this.dealerId = dealerId;
		this.name = name;
		this.description = description;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
}
