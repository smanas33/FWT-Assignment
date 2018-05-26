package com.yash.moviebookingsystem.screenserviceimpl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.exception.ScreenExistException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.screenservice.ScreenService;

public class ScreenServiceImpl implements ScreenService {
	
	ScreenDAO screenDAO;		
	 
	private final static Logger LOGGER = Logger.getLogger(ScreenServiceImpl.class);
	
	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	public int addScreen(Screen screen) throws IOException {
		
		int insertedScreen = 0;
		
		if(isScreenNull(screen)){
			LOGGER.error("Screen Object should not be null !!");
			throw new ScreenNullPointerException("Screen Object should not be null !!");
		}
		else {
			System.out.println("inside screen service impl");
			screenDAO.insertScreen(screen);
			insertedScreen = 1;
		}
		return insertedScreen;
	}

	private boolean isScreenEmpty(List<Screen> screens) {
		return !screens.isEmpty();
	}

	private boolean isScreenExist(Screen screenInRepository,Screen screen) {
		return screenInRepository.getScreenName().equalsIgnoreCase(screen.getScreenName());
	}

	private boolean isScreenNull(Screen screen) {
		return null == screen;
	}

	public int updateScreen(Screen screen) throws FileEmptyException, IOException {
		List<Screen> screens = screenDAO.getAllScreen();
		int insertedScreen = 0;
		if(isScreenEmpty(screens)) {
			for (Screen screenInRepository : screens) {
				if(isScreenExist(screenInRepository,screen)){
					LOGGER.error("Screen already exists");
					throw new ScreenExistException("Screen already exists");
				}
			}
			if(screens.size() >= 3){
				LOGGER.error("No more Screen can add");
				System.out.println("No more Screen can add");
				return insertedScreen;	
			}
		}
		return 0;
	}

}
