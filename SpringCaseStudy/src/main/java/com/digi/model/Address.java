package com.digi.model;

public class description {
	
	private int descriptionId;
	private String descriptionName;
	private String city;
	private String state;
	private String country;
	
	public description() {
		super();
	}

	public description(int descriptionId, String descriptionName, String city, String state, String country) {
		super();
		this.descriptionId = descriptionId;
		this.descriptionName = descriptionName;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public int getdescriptionId() {
		return descriptionId;
	}

	public void setdescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}

	public String getdescriptionName() {
		return descriptionName;
	}

	public void setdescriptionName(String descriptionName) {
		this.descriptionName = descriptionName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
