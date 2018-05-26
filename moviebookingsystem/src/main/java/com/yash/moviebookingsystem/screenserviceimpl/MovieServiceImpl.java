package com.yash.moviebookingsystem.screenserviceimpl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.screenservice.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;
	private final static Logger LOGGER = Logger.getLogger(MovieServiceImpl.class);
	
	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public boolean addMovie(Screen screen) throws IOException {
		boolean insertedScreen = false;
		
		if(isScreenNull(screen)) {
			LOGGER.error("Screen object should not be null");
			throw new ScreenNullPointerException("Screen object should not be null");
		}
		
		else {
			insertedScreen = movieDAO.insertMovie(screen);
			LOGGER.info("Movie inserted");
		}	
		return insertedScreen;
	}

	private boolean isScreenNull(Screen screen) {
		return null == screen;
	}

}
