package com.yash.moviebookingsystem.screendaoimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.util.FileUtil;

/**
 * This is DAOImpl class for Movie class. Here File handling connection has done
 * 
 * @author sahoo.manas
 * 
 */
public class MovieDAOImpl implements MovieDAO {

	private FileUtil fileUtil;
	private final static Logger LOGGER = Logger.getLogger(ScreenDAOImpl.class);

	public MovieDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public boolean insertMovie(Screen screen) throws IOException {
		boolean rowAffected = false;
		List<Screen> screenList = new ArrayList<Screen>();
		screenList.add(screen);
		LOGGER.info("Inserting movie inside moviedaoimpl");
		rowAffected = fileUtil.updateListOfScreens(screenList);		
		return rowAffected;
	}

	public Screen getScreenObject(String screenName) {
		LOGGER.info("getting screen object inside moviedaoimpl");
		Screen screen = fileUtil.getScreenObject(screenName);
		return screen;
	}

}
