package com.yash.moviebookingsystem.screendaoimpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.util.FileUtil;

public class ScreenDAOImpl implements ScreenDAO {

	private FileUtil fileUtil;
	private static String filePath = "src//main//resources//operatormenu//screen.json";
	private final static Logger LOGGER = Logger.getLogger(ScreenDAOImpl.class);
	
	public ScreenDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public int insertScreen(Screen screen) throws IOException {
		int rowAffected = 0;
		rowAffected = fileUtil.writeIntoJsonFile(screen);
		LOGGER.info("Screen inserted");
		return rowAffected;
	}

	public List<Screen> getAllScreen() throws FileEmptyException, IOException {
		List<Screen> screenLists = new ArrayList<Screen>();
		screenLists = fileUtil.readFromJsonFile(filePath);
		LOGGER.info(screenLists);
		return screenLists;
	}
}
