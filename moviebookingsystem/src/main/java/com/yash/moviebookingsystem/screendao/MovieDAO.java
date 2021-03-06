package com.yash.moviebookingsystem.screendao;

import java.io.IOException;

import com.yash.moviebookingsystem.model.Screen;

/**
 * 
 * @author sahoo.manas
 * 
 */
public interface MovieDAO {

	public boolean insertMovie(Screen screen) throws IOException;

	public Screen getScreenObject(String screenName);

}
