package com.yash.moviebookingsystem.screendao;

import java.io.IOException;

import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;

public interface MovieDAO {

	int insertMovie(Screen screen, Movie movie) throws IOException;

}
