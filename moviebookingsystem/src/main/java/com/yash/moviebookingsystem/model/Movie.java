package com.yash.moviebookingsystem.model;

import java.util.Date;
import java.util.List;

/**
 * This is simple POJO movie class
 * 
 * @author sahoo.manas
 * 
 */
public class Movie {

	private String movieTitle;
	private String production;
	private List<String> actors;
	private Date duration;

	public Movie(String movieTitle, String production, List<String> actors, Date duration) {
		super();
		this.movieTitle = movieTitle;
		this.production = production;
		this.actors = actors;
		this.duration = duration;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public String getProduction() {
		return production;
	}

	public List<String> getActors() {
		return actors;
	}

	public Date getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "Movie [movieTitle=" + movieTitle + ", production=" + production + ", actors=" + actors + ", duration="
				+ duration + "]";
	}

}
