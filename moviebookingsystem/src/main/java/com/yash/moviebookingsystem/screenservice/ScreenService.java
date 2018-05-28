package com.yash.moviebookingsystem.screenservice;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.model.Screen;

/**
 * 
 * @author sahoo.manas
 * 
 */
public interface ScreenService {

	public int addScreen(Screen screen) throws FileEmptyException, FileNotFoundException, IOException;

}
