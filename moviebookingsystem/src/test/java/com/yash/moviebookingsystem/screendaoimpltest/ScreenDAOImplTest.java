package com.yash.moviebookingsystem.screendaoimpltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.exception.FileNotExistException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.screendaoimpl.ScreenDAOImpl;
import com.yash.moviebookingsystem.util.FileUtil;

public class ScreenDAOImplTest {

	private FileUtil fileUtil;
	private ScreenDAO screenDAO;

	@Before
	public void init() {
		fileUtil = mock(FileUtil.class);
		screenDAO = new ScreenDAOImpl(fileUtil);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = FileNotExistException.class)
	public void getAllScreen_ShouldThrowFileNotExistException_WhenGivenFileNotExist()
			throws FileEmptyException, IOException {
		when(fileUtil.readFromJsonFile()).thenThrow(FileNotExistException.class);
		screenDAO.getAllScreen();
	}

	@SuppressWarnings("unchecked")
	@Test(expected = FileEmptyException.class)
	public void getAllScreen_ShouldThrowFileEmptyException_WhenGivenFileIsEmpty()
			throws FileEmptyException, IOException {
		when(fileUtil.readFromJsonFile()).thenThrow(FileEmptyException.class);
		screenDAO.getAllScreen();
	}

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnOne() throws IOException {
		Screen screen = new Screen(100, "screen1");
		when(fileUtil.writeIntoJsonFile(screen)).thenReturn(1);
		int rowAffected = screenDAO.insertScreen(screen);
		assertEquals(1, rowAffected);
	}

}
