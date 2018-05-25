package com.yash.moviebookingsystem.screendao;

import java.io.IOException;
import java.util.List;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.model.Screen;

public interface ScreenDAO {

	int insertScreen(Screen screen) throws IOException;

	List<Screen> getAllScreen() throws FileEmptyException, IOException;

}
