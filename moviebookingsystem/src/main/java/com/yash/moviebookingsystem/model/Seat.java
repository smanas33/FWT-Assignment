package com.yash.moviebookingsystem.model;

/**
 * This is simple POJO seat class
 * 
 * @author sahoo.manas
 * 
 */
public class Seat {
	private int seatNo;
	private boolean available;

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
