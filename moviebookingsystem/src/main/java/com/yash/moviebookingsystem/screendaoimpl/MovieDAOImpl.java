package com.yash.moviebookingsystem.screendaoimpl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.util.FileUtil;

public class MovieDAOImpl implements MovieDAO {
	
	private FileUtil fileUtil;
	private final static Logger LOGGER = Logger.getLogger(ScreenDAOImpl.class);
	
	public MovieDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public boolean insertMovie(Screen screen) throws IOException {
		boolean rowAffected = false;
		List<Screen> screenList = null;
		rowAffected = fileUtil.updateListOfScreens(screenList);
		LOGGER.info("Screen inserted");
		return rowAffected;
	}

}
