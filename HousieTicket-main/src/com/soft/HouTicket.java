package com.soft;

import java.util.ArrayList;
import java.util.List;

public class HouTicket {

	private List<HouTicketRows> rows =new ArrayList<>();
	
	public List<HouTicketRows> getTicketRows(){
		return this.rows;
	}
	
	
	public void add(HouTicketRows row) {
		this.rows.add(row);
	}
}
