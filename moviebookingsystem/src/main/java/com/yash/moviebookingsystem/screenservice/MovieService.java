package com.yash.moviebookingsystem.screenservice;

import java.io.IOException;

import com.yash.moviebookingsystem.model.Movie;

/**
 * 
 * @author sahoo.manas
 * 
 */
public interface MovieService {

	public boolean addMovie(Movie movie, String screenName) throws IOException;

}
