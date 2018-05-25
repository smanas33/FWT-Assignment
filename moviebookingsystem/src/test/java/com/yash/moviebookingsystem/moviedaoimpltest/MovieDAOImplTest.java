package com.yash.moviebookingsystem.moviedaoimpltest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.exception.MovieNullPointerException;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.screendaoimpl.MovieDAOImpl;
import com.yash.moviebookingsystem.util.FileUtil;

public class MovieDAOImplTest {
	
	MovieDAO movieDAO;
	private FileUtil fileUtil;
	
	@Before
	public void init(){
		movieDAO = new MovieDAOImpl(fileUtil);
	}
	
	@Test(expected = MovieNullPointerException.class)
	public void addMovieToScreen_ShouldThrowMovieNullPointerException_WhenNullMovieObjectGiven() throws IOException {
		Movie movie = null;
		Screen screen = new Screen(100, "Screen1");
		movieDAO.insertMovie(screen, movie);
	}

}
