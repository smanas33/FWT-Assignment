package com.yash.moviebookingsystem.screendao;

import java.util.List;

import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Show;

/**
 * 
 * @author sahoo.manas
 * 
 */
public interface ShowDAO {

	public int insertShow(Show show);

	public List<Show> getAllShow();

	public Screen getScreenObject(String screenName);

	public int updateShows(List<Show> showList);

}
