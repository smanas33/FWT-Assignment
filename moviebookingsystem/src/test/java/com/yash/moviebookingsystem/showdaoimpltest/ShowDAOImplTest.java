package com.yash.moviebookingsystem.showdaoimpltest;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.exception.MovieNullPointerException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.screendao.ShowDAO;
import com.yash.moviebookingsystem.screendaoimpl.ShowDAOImpl;
import com.yash.moviebookingsystem.util.FileUtil;

public class ShowDAOImplTest {

	private FileUtil fileUtil;
	private ShowDAO showDAO;
	
	@Before
	public void init(){
		showDAO = new ShowDAOImpl(fileUtil);
	}
	
	@Test(expected = MovieNullPointerException.class)
	public void addShow_ShouldThrowShowNullPointerException_WhenNullShowObjectGiven() {
		Screen screen = null;
		Show show = new Show("", screen, "");
		showDAO.insertShow(show);
	}

}
