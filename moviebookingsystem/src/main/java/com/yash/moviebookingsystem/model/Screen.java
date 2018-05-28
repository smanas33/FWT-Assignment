package com.yash.moviebookingsystem.model;

import java.util.List;
import java.util.Map;

/**
 * This is simple POJO screen class
 * 
 * @author sahoo.manas
 * 
 */
public class Screen {

	static final String PLATINUM_CLASS = "Platinum";
	static final String GOLD_CLASS = "Gold";
	static final String SILVER_CLASS = "Silver";

	private int screenId;
	private String screenName;
	private Movie movie;
	Map<String, List<Row>> seatings;
	int totalShows;

	public Screen(int screenId, String screenName) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
	}

	public Screen() {

	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Map<String, List<Row>> getSeatings() {
		return seatings;
	}

	public void setSeatings(Map<String, List<Row>> seatings) {
		this.seatings = seatings;
	}

	public int getTotalShows() {
		return totalShows;
	}

	public void setTotalShows(int totalShows) {
		this.totalShows = totalShows;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + ", movie=" + movie + ", seatings="
				+ seatings + ", totalShows=" + totalShows + "]";
	}

}
