package com.yash.moviebookingsystem.screenserviceimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.ShowExistException;
import com.yash.moviebookingsystem.exception.ShowNullPointerException;
import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.screendao.ShowDAO;
import com.yash.moviebookingsystem.screenservice.ShowService;

public class ShowServiceImpl implements ShowService {

	private ShowDAO showDAO;
	private final static Logger LOGGER = Logger.getLogger(ShowServiceImpl.class);
	
	public ShowServiceImpl(ShowDAO showDAO) {
		this.showDAO = showDAO;
	}

	public int addShow(Show show) {
		List<Show> showList = showDAO.getAllShow();
		int rowAffected = 0;
		if(isShowNull(show)) {
			LOGGER.error("ShowObject should not be null");
			throw new ShowNullPointerException("ShowObject should not be null");
		}
		
		if(isShowListEmpty(showList)) {
			for (Show showInRepository : showList) {
				if(showInRepository.getShowTime().equals(show.getShowTime())) {
					LOGGER.error("Screen already exists");
					throw new ShowExistException("Screen already exists");
				}
			}
			if(showList.size() >= 5) {
				LOGGER.error("No more shows added");
				return rowAffected;
			}
		}
		rowAffected = showDAO.insertShow(show);
		return rowAffected;
	}

	private boolean isShowListEmpty(List<Show> showList) {
		return !showList.isEmpty();
	}
	
	private boolean isShowNull(Show show) {
		return null == show;
	}
	
	
}
