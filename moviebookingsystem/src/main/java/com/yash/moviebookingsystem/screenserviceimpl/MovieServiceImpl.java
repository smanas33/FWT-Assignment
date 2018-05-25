package com.yash.moviebookingsystem.screenserviceimpl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.MovieNullPointerException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.screenservice.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;
	private final static Logger LOGGER = Logger.getLogger(MovieServiceImpl.class);
	
	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public int addMovie(Screen screen, Movie movie) throws IOException {
		int insertedScreen = 0;
		
		if(isMovieNull(movie)) {
			LOGGER.error("Null movie can not add to screen");
			throw new MovieNullPointerException("Null movie can not add to screen");
		}
		
		if(isScreenNull(screen)) {
			LOGGER.error("Screen object should not be null");
			throw new ScreenNullPointerException("Screen object should not be null");
		}
		
		else {
			insertedScreen = movieDAO.insertMovie(screen, movie);
			LOGGER.info("Movie inserted");
		}	
		return insertedScreen;
	}

	private boolean isScreenNull(Screen screen) {
		return null == screen;
	}

	private boolean isMovieNull(Movie movie) {
		return null == movie;
	}

}
