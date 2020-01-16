package com.digi.SpringHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer10")
public class CustomerDet {
	@Id
	private int cust_id;
	private String name;
	private String address;
	
	
	public CustomerDet() {
		super();
	}

	public CustomerDet(int cust_id, String name, String address) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.address = address;
	}

	/**
	 * @return the cust_id
	 */
	public int getCust_id() {
		return cust_id;
	}

	/**
	 * @param cust_id the cust_id to set
	 */
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

	

}
