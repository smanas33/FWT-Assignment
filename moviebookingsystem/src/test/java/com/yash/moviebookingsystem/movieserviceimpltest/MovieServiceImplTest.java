package com.yash.moviebookingsystem.movieserviceimpltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.exception.MovieNullPointerException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.screenservice.MovieService;
import com.yash.moviebookingsystem.screenserviceimpl.MovieServiceImpl;

public class MovieServiceImplTest {

	private MovieService movieService;
	private MovieDAO movieDAO;

	@Before
	public void init() {
		movieDAO = mock(MovieDAO.class);
		movieService = new MovieServiceImpl(movieDAO);
	}

	@Test(expected = MovieNullPointerException.class)
	public void addMovieToScreen_ShouldThrowMovieNullPointerException_WhenNullMovieObjectGiven() throws IOException {
		Movie movie = null;
		String screenName = null;
		movieService.addMovie(movie, screenName);
	}

	@Test(expected = ScreenNullPointerException.class)
	public void addMovieToScreen_ShouldThrowScreenNullPointerException_WhenNullScreenObjectGiven()
			throws ParseException, IOException {
		Movie movie = null;
		String screenName = null;
		movieService.addMovie(movie, screenName);
	}

	@Test
	public void addMovieToScreen_MovieObjectAndScreenObjectGiven_ShouldReturnOne() throws ParseException, IOException {
		List<String> actors = Arrays.asList("Josh Brolin", "Josh Brolin");
		String duration = "2:00";
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date time = format.parse(duration);
		String screenName = "Screen1";
		Movie movie = new Movie("Deadpool 2", "Marvel", actors, time);
		boolean rowAdded = movieService.addMovie(movie, screenName);
		assertEquals(1, rowAdded);
	}
}
