package com.yash.moviebookingsystem.screenserviceimpl;

import java.util.List;

import com.yash.moviebookingsystem.exception.ScreenExistException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.screenservice.ScreenService;

public class ScreenServiceImpl implements ScreenService {
	
	ScreenDAO screenDAO;		
	 
	
	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	public int addScreen(Screen screen) {
		List<Screen> screens = screenDAO.getAllScreen();
		int insertedScreen = 0;
		
		if(isScreenNull(screen)){
			throw new ScreenNullPointerException("Screen Object should not be null !!");
		}
		
		if(isScreenEmpty(screens)){
			for (Screen screenInRepository : screens) {
				if(isScreenExist(screenInRepository,screen)){
					System.out.println("already exists");
					throw new ScreenExistException("Screen already exists");
				}
			}
			if(screens.size() >= 3){
				System.out.println("Screen Size should not more than 3");
				return insertedScreen;	
			}
		} else {
			screens.add(screen);
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

}
