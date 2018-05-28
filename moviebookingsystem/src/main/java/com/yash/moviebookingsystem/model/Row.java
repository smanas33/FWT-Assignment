package com.yash.moviebookingsystem.model;

import java.util.List;

/**
 * This is simple POJO row class
 * 
 * @author sahoo.manas
 * 
 */
public class Row {

	private String rowNo;
	private List<Seat> seats;

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

}
