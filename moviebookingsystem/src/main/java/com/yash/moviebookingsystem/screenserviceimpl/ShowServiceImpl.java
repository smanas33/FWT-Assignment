package com.yash.moviebookingsystem.screenserviceimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.ScreenExistException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.screendao.ShowDAO;
import com.yash.moviebookingsystem.screenservice.ShowService;

/**
 * This is serviceimpl class for Show class. Here all logic related to Show
 * object are done. Like adding Show
 * 
 * @author sahoo.manas
 * 
 */
public class ShowServiceImpl implements ShowService {

	private ShowDAO showDAO;
	private final static Logger LOGGER = Logger.getLogger(ShowServiceImpl.class);

	public ShowServiceImpl(ShowDAO showDAO) {
		this.showDAO = showDAO;
	}

	public int addShow(Show show, String screenName) {
		List<Show> showList = showDAO.getAllShow();
		Screen screen = null;
		try {
			screen = showDAO.getScreenObject(screenName);
			if (screen == null) {
				LOGGER.error("Screen not exist");
			}
		} catch (ScreenExistException exception) {
			LOGGER.error("Screen not exist");
		} catch (NullPointerException exception) {
			LOGGER.error("Screen not exist");
		}

		int rowAffected = 0;
		if (screen.getScreenName().equalsIgnoreCase(screenName)) {
			try {
				if (isShowNull(show)) {
					LOGGER.error("Show Object should not be null");
					return rowAffected;
				}

				if (isShowListEmpty(showList)) {
					for (Show showInRepository : showList) {
						if (showInRepository.getShowTime().equals(show.getShowTime())) {
							LOGGER.error("Show already exists");
							return rowAffected;
						}
					}
					if (showList.size() >= 5) {
						LOGGER.error("No more shows added");
						return rowAffected;
					}
					showList.add(show);
					LOGGER.info("Updating Showlist inside showserviceimpl");
					showDAO.updateShows(showList);
					rowAffected = 1;
				}
				LOGGER.info("adding showlist inside showserviceimpl");
				show.setScreen(screen);
				rowAffected = showDAO.insertShow(show);
				rowAffected = 1;
			} catch (ScreenNullPointerException exception) {
				exception.printStackTrace();
			} catch (ScreenExistException exception) {
				exception.printStackTrace();
			}
		}
		LOGGER.error("Entered Screen not exist !!");
		return rowAffected;
	}

	private boolean isShowListEmpty(List<Show> showList) {
		return !showList.isEmpty();
	}

	private boolean isShowNull(Show show) {
		return null == show;
	}

}
