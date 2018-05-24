package com.yash.moviebookingsystem.model;

public class Screen {
	
	private int screenId;
	private String screenName;

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

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + "]";
	}
	
}
