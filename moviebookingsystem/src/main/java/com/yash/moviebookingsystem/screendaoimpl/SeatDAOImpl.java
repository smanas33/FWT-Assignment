package com.yash.moviebookingsystem.screendaoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.SeatDAO;
import com.yash.moviebookingsystem.util.FileUtil;

/**
 * This is DAOImpl class for Seat class. Here File handling connection has done
 * 
 * @author dell
 *
 */
public class SeatDAOImpl implements SeatDAO {

	private FileUtil fileUtil;
	private final static Logger LOGGER = Logger.getLogger(ScreenDAOImpl.class);

	public SeatDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public Screen getScreenObject(String screenName) {
		LOGGER.info("getting screen object inside moviedaoimpl");
		Screen screen = fileUtil.getScreenObject(screenName);
		return screen;
	}

	public boolean addSeatingArrangement(Screen screen) {
		boolean rowAffected = false;
		List<Screen> screenList = new ArrayList<Screen>();
		screenList.add(screen);
		LOGGER.info("Inserting movie inside moviedaoimpl");
		rowAffected = fileUtil.updateListOfScreens(screenList);
		return rowAffected;
	}
}
