package com.digi.dao;
import java.util.*;

import com.digi.model.description;

public class AddressDaoImpl {

	private List<description>descriptiones;
	
	
	public AddressDaoImpl() {
		this.descriptiones = new ArrayList<description>();
		descriptiones.add(new description(1, "Peachtree Street", "Atlanta", "Georgia", "US"));
	}
	
	public List<description> getdescriptiones(){
		return descriptiones;
	}
	
	public void setdescriptiones(List<description> descriptiones) {
		this.descriptiones = descriptiones;
	}
	
	public void adddescription(description description) {
		descriptiones.add(description);
	}
  	
}
