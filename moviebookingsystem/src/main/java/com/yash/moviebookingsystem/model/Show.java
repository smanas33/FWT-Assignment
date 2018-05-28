package com.yash.moviebookingsystem.model;

import java.util.ArrayList;

/**
 * This is simple POJO show class
 * 
 * @author sahoo.manas
 * 
 */
public class Show {

	private String showName;
	private String showTime;
	private Screen screen;
	private ArrayList<Seat> seats;

	public Show(String showName, String showTime) {
		this.showName = showName;
		this.showTime = showTime;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public String getShowName() {
		return showName;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public Screen getScreen() {
		return screen;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}
}
