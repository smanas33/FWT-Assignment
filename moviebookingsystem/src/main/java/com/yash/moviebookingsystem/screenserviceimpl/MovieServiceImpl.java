package com.yash.moviebookingsystem.screenserviceimpl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.MovieNullPointerException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.screenservice.MovieService;

/**
 * This is serviceimpl class for movie class. Here all logic related to movie
 * object are done. Like adding movie
 * 
 * @author sahoo.manas
 * 
 */
public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;
	private final static Logger LOGGER = Logger.getLogger(MovieServiceImpl.class);

	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public boolean addMovie(Movie movie, String screenName) throws IOException {

		Screen screen = movieDAO.getScreenObject(screenName);
		boolean insertedScreen = false;

		try {
			if (isScreenNull(movie) || isScreenNameNull(screenName) || isScreenNameEmpty(screenName)) {
				LOGGER.error("Movie object or screen name should not be null");
				return insertedScreen;
			} else {
				screen.setMovie(movie);
				LOGGER.error("inserting movie inside movieserviceimpl");
				insertedScreen = movieDAO.insertMovie(screen);
			}

		} catch (MovieNullPointerException exception) {
			exception.printStackTrace();
		} catch (ScreenNullPointerException exception) {
			exception.printStackTrace();
		}

		return insertedScreen;
	}

	private boolean isScreenNameEmpty(String screenName) {
		return screenName.isEmpty();
	}

	private boolean isScreenNameNull(String screenName) {
		return null == screenName;
	}

	private boolean isScreenNull(Movie movie) {
		return null == movie;
	}

}
