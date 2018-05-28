package com.yash.moviebookingsystem.showserviceimpltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.exception.ShowExistException;
import com.yash.moviebookingsystem.exception.ShowNullPointerException;
import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.screendao.ShowDAO;
import com.yash.moviebookingsystem.screenservice.ShowService;
import com.yash.moviebookingsystem.screenserviceimpl.ShowServiceImpl;

public class ShowServiceImplTest {

	private ShowDAO showDAO;
	private ShowService showService;

	@Before
	public void init() {
		showDAO = mock(ShowDAO.class);
		showService = new ShowServiceImpl(showDAO);
	}

	@Test(expected = ShowNullPointerException.class)
	public void addShow_ShouldThrowShowNullPointerException_WhenNullShowObjectGiven() {
		Show show = null;
		String screenName = "";
		showService.addShow(show, screenName);
	}

	@Test
	public void addShow_ShowObjectGiven_ShouldReturnOne() {
		Show show = new Show("noon", "12:00");
		String screenName = "";
		when(showDAO.insertShow(show)).thenReturn(1);
		int rowAdded = showService.addShow(show, screenName);
		assertEquals(1, rowAdded);
	}

	@Test
	public void addShow_ShowObjectGivenMoreThanFour_ShouldReturnZero() {
		Show show = new Show("noon", "12:00");
		String screenName = "";
		List<Show> showList = Arrays.asList(new Show("morning", "9:00"), new Show("matinee", "15:00"),
				new Show("evening", "18:00"), new Show("night", "21:00"));
		when(showDAO.getAllShow()).thenReturn(showList);
		int rowAdded = showService.addShow(show, screenName);
		assertEquals(0, rowAdded);
	}

	@Test(expected = ShowExistException.class)
	public void addShow_ShowObjectGivenWithSameShowTime_ShouldThrowShowExistException() {
		Show show = new Show("noon", "21:00");
		String screenName = "";
		List<Show> showList = Arrays.asList(new Show("morning", "9:00"), new Show("matinee", "15:00"),
				new Show("night", "21:00"));
		when(showDAO.getAllShow()).thenReturn(showList);
		showService.addShow(show, screenName);
	}

}
