package com.yash.moviebookingsystem.screenserviceimpltest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.exception.ScreenExistException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;

import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.screenservice.ScreenService;
import com.yash.moviebookingsystem.screenserviceimpl.ScreenServiceImpl;

public class ScreenServiceImplTest {

	private ScreenService screenService;
	private ScreenDAO screenDAO;

	@Before
	public void init() {
		screenDAO = mock(ScreenDAO.class);
		screenService = new ScreenServiceImpl(screenDAO);
	}

	@Test(expected = ScreenNullPointerException.class)
	public void addScreen_ShouldThrowException_WhenNullScreenObjectGiven() throws FileEmptyException, IOException {
		Screen screen = null;
		screenService.addScreen(screen);
	}

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnOne() throws FileEmptyException, IOException {
		Screen screen = new Screen(100, "Screen1");
		when(screenDAO.insertScreen(screen)).thenReturn(1);
		int rowAdded = screenService.addScreen(screen);
		assertEquals(1, rowAdded);
	}

	@Test(expected = ScreenExistException.class)
	public void addScreen_AlreadyExitScreenObjectGiven_ShouldThrowScreenExistException()
			throws FileEmptyException, IOException {
		Screen screen = new Screen(100, "Screen1");
		when(screenDAO.getAllScreen()).thenReturn(Arrays.asList(new Screen(100, "Screen1")));
		screenService.addScreen(screen);
	}

	@Test
	public void addScreen_MoreThanFourScreenObjectGiven_ShouldReturnZero() throws FileEmptyException, IOException {
		Screen screen = new Screen(100, "Screen1");
		when(screenDAO.getAllScreen()).thenReturn(
				Arrays.asList(new Screen(200, "Screen2"), new Screen(300, "Screen3"), new Screen(400, "Screen4")));
		int rowAdded = screenService.addScreen(screen);
		assertEquals(0, rowAdded);
	}

}
