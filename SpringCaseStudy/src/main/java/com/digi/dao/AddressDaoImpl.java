package com.digi.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.digi.model.description;

public class descriptionDaoImpl {
	
	private List<description> descriptiones;
	
	public descriptionDaoImpl() {
		this.descriptiones = new ArrayList<description>();
		descriptiones.add(new description(1, "Amy", "Atlanta", "GA", "USA"));
	}
		

	public List<description> getdescriptiones() {
			return descriptiones;
		}
		
	public void setdescriptiones(List<description> descriptiones) {
			this.descriptiones = descriptiones;
		}
	
	public void adddescription(description description) {
		descriptiones.add(description);
	}

	

}
