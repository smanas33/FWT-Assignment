package com.yash.moviebookingsystem.screendaoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.screendao.ShowDAO;
import com.yash.moviebookingsystem.screenserviceimpl.ShowServiceImpl;
import com.yash.moviebookingsystem.util.FileUtil;

/**
 * This is DAOImpl class for Show class. Here File handling connection has done
 * 
 * @author sahoo.manas
 * 
 */
public class ShowDAOImpl implements ShowDAO {

	private FileUtil fileUtil;
	private final static Logger LOGGER = Logger.getLogger(ShowServiceImpl.class);

	public ShowDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public int insertShow(Show show) {
		int rowAffected = 0;
		LOGGER.info("Show inserted inside showdaoimpl");
		rowAffected = fileUtil.writeIntoShowJsonFile(show);
		return rowAffected;
	}

	public List<Show> getAllShow() {
		List<Show> showList = new ArrayList<Show>();
		LOGGER.info(showList);
		showList = fileUtil.readShowFromJsonFile();
		return showList;
	}

	public Screen getScreenObject(String screenName) {
		LOGGER.info("getting screen object inside screendaoimpl");
		Screen screen = fileUtil.getScreenObject(screenName);
		return screen;
	}

	public int updateShows(List<Show> showList) {
		int rowadded = 0;
		LOGGER.info("Updating screenlist inside screendaoimpl ");
		rowadded = fileUtil.updateListOfShows(showList);
		return rowadded;
	}

}
