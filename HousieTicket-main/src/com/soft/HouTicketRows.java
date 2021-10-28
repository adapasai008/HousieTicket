package com.soft;

import java.util.ArrayList;
import java.util.List;

public class HouTicketRows {

	private List<Object> cloumns=new ArrayList<Object>();;

	public HouTicketRows() {
		
	}
	
	public List<Object> getcloumns() {
		return this.cloumns;
	}
	
	public void addNumber(int number) {
		this.cloumns.add(number);
	}

}
