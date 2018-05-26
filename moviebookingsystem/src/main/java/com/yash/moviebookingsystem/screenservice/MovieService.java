package com.yash.moviebookingsystem.screenservice;

import java.io.IOException;

import com.yash.moviebookingsystem.model.Screen;

public interface MovieService {

	public boolean addMovie(Screen screen) throws IOException;
	
}
