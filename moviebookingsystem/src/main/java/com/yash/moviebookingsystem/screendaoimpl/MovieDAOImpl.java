package com.yash.moviebookingsystem.screendaoimpl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.util.FileUtil;

public class MovieDAOImpl implements MovieDAO {
	
	private FileUtil fileUtil;
	private final static Logger LOGGER = Logger.getLogger(ScreenDAOImpl.class);
	
	public MovieDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public int insertMovie(Screen screen, Movie movie) throws IOException {
		int rowAffected = 0;
		rowAffected = fileUtil.writeMovieIntoJsonFile(screen);
		LOGGER.info("Screen inserted");
		return rowAffected;
	}

}
