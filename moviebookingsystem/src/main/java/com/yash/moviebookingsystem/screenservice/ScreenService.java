package com.yash.moviebookingsystem.screenservice;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.model.Screen;

public interface ScreenService {

	int addScreen(Screen screen) throws FileEmptyException, FileNotFoundException, IOException;

}
