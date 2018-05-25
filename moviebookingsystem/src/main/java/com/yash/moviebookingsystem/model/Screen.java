package com.yash.moviebookingsystem.model;

public class Screen {
	
	private int screenId;
	private String screenName;
	private Movie movie;

	public Screen(int screenId, String screenName) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
	}
	
	public int getScreenId() {
		return screenId;
	}

	public String getScreenName() {
		return screenName;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + ", movie=" + movie + "]";
	}

}
