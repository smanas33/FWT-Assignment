package com.yash.moviebookingsystem.screendao;

import java.io.IOException;
import java.util.List;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.model.Screen;

/**
 * 
 * @author sahoo.manas
 * 
 */
public interface ScreenDAO {

	public int insertScreen(Screen screen) throws IOException;

	public List<Screen> getAllScreen() throws FileEmptyException, IOException;

	public boolean updateScreen(List<Screen> screens);

}
