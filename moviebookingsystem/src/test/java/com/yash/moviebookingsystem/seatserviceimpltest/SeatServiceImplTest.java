package com.yash.moviebookingsystem.seatserviceimpltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.exception.ScreenExistException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.SeatDAO;
import com.yash.moviebookingsystem.screenservice.SeatService;
import com.yash.moviebookingsystem.screenserviceimpl.SeatServiceImpl;

public class SeatServiceImplTest {

	private SeatDAO seatDAO;
	private SeatService seatService;

	@Before
	public void init() {
		seatDAO = mock(SeatDAO.class);
		seatService = new SeatServiceImpl(seatDAO);
	}

	@Test(expected = ScreenNullPointerException.class)
	public void designSeatingArrangement_RowCountOnlyOneGiven_ShouldReturnOne() {
		Screen screen = new Screen(100, "Screen1");
		when(seatDAO.addSeatingArrangement(screen)).thenReturn(true);
		boolean rowAdded = seatService.addSeatingArrangementIntoFile("screen1");
		assertEquals(true, rowAdded);
	}

	@Test(expected = ScreenNullPointerException.class)
	public void designSeatingArrangement_RowCountZeroGiven_ShouldReturnZero() {
		Screen screen = new Screen(100, "Screen1");
		when(seatDAO.addSeatingArrangement(screen)).thenReturn(false);
		boolean rowAdded = seatService.addSeatingArrangementIntoFile("screen1");
		assertEquals(false, rowAdded);
	}

	@Test(expected = ScreenNullPointerException.class)
	public void designSeatingArrangement_NullScreenGiven_ShouldThrowScreenNullPointerException() {
		// Screen screen = null;
		seatService.addSeatingArrangementIntoFile("screen1");
	}

	@Test
	public void designSeatingArrangement_RowCountTwoOrMoreGiven_ShouldReturnMultiplyToThreeInput() {
		Screen screen = new Screen(100, "Screen1");
		when(seatDAO.addSeatingArrangement(screen)).thenReturn(true);
		boolean rowAdded = seatService.addSeatingArrangementIntoFile("screen1");
		assertEquals(true, rowAdded);
	}

	@Test(expected = ScreenNullPointerException.class)
	public void getScreenObject_NullScreenGiven_ShouldThrowScreenNullPointerException() {
		// Screen screen = null;
		seatDAO.getScreenObject("screen1");
	}

	@Test(expected = ScreenExistException.class)
	public void getScreenObject_OtherScreenNameGiven_ShouldThrowScreenNOtExistException() {
		// Screen screen = null;
		seatDAO.getScreenObject("screen111");
	}

	@Test
	public void getScreenObject_ScreenNameGiven_ShouldReturnScreenName() {
		when(seatDAO.getScreenObject("screen1")).thenReturn(new Screen(100, "screen1"));
		Screen actual = new Screen(100, "screen1");
		Screen expected = new Screen(100, "screen1");
		assertEquals(expected, actual);
	}
}
