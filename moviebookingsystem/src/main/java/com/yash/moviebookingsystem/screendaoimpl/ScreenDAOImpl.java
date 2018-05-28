package com.yash.moviebookingsystem.screendaoimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.util.FileUtil;

/**
 * This is DAOImpl class for Screen class. Here File handling connection has
 * done
 * 
 * @author sahoo.manas
 * 
 */
public class ScreenDAOImpl implements ScreenDAO {

	private FileUtil fileUtil;
	private final static Logger LOGGER = Logger.getLogger(ScreenDAOImpl.class);

	public ScreenDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public int insertScreen(Screen screen) throws IOException {
		int rowAffected = 0;
		rowAffected = fileUtil.writeIntoJsonFile(screen);
		LOGGER.info("Screen inserted inside screendaoimpl");
		return rowAffected;
	}

	public List<Screen> getAllScreen() {
		List<Screen> screenLists = new ArrayList<Screen>();
		LOGGER.info("getting screen object inside screendaoimpl");
		screenLists = fileUtil.readFromJsonFile();
		return screenLists;
	}

	public boolean updateScreen(List<Screen> screens) {
		boolean screenAdded = false;
		LOGGER.info("Updating screenlist inside screendaoimpl ");
		screenAdded = fileUtil.updateListOfScreens(screens);
		return screenAdded;
	}
}
