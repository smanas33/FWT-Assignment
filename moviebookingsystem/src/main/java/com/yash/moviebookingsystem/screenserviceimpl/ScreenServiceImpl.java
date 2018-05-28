package com.yash.moviebookingsystem.screenserviceimpl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.ScreenExistException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.screenservice.ScreenService;

/**
 * This is serviceimpl class for screen class. Here all logic related to screen
 * object are done. Like adding screen
 * 
 * @author sahoo.manas
 * 
 */
public class ScreenServiceImpl implements ScreenService {

	private ScreenDAO screenDAO;

	private final static Logger LOGGER = Logger.getLogger(ScreenServiceImpl.class);

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	public int addScreen(Screen screen) throws IOException {
		List<Screen> screens = screenDAO.getAllScreen();
		int insertedScreen = 0;
		try {
			if (isScreenNull(screen)) {
				LOGGER.error("Screen Object should not be null !!");
				return insertedScreen;
			}
			if (isScreenEmpty(screens)) {
				for (Screen screenInRepository : screens) {
					if (isScreenExist(screenInRepository, screen)) {
						LOGGER.error("Screen already exists");
						return insertedScreen;
					}
					if (screens.size() >= 3) {
						LOGGER.error("No more Screen can add");
						System.out.println("No more Screen can add");
						return insertedScreen;
					}
				}
				screens.add(screen);
				LOGGER.info("Updating screenlist inside screenserviceimpl");
				screenDAO.updateScreen(screens);
				insertedScreen = 1;

			} else {
				LOGGER.info("inserting screent inside screenserviceimpl");
				screenDAO.insertScreen(screen);
				insertedScreen = 1;
			}
		} catch (ScreenNullPointerException exception) {
			exception.printStackTrace();
		} catch (ScreenExistException exception) {
			exception.printStackTrace();
		}
		return insertedScreen;
	}

	private boolean isScreenEmpty(List<Screen> screens) {
		return !screens.isEmpty();
	}

	private boolean isScreenExist(Screen screenInRepository, Screen screen) {
		return screenInRepository.getScreenName().equalsIgnoreCase(screen.getScreenName());
	}

	private boolean isScreenNull(Screen screen) {
		return null == screen;
	}

}
