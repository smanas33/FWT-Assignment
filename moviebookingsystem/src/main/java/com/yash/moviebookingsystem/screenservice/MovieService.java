package com.yash.moviebookingsystem.screenservice;

import java.io.IOException;

import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;

public interface MovieService {

	int addMovie(Screen screen, Movie movie) throws IOException;
	
}
