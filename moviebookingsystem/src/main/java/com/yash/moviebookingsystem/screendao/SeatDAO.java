package com.yash.moviebookingsystem.screendao;

import com.yash.moviebookingsystem.model.Screen;

/**
 * 
 * @author sahoo.manas
 * 
 */
public interface SeatDAO {

	public Screen getScreenObject(String screenName);

	public boolean addSeatingArrangement(Screen screen);
	
}
