package com.yash.moviebookingsystem.fileutiltest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.util.FileUtil;

public class FileUtilTest {

	private FileUtil fileUtil;

	@Before
	public void init() {
		fileUtil = new FileUtil();
	}

	@Test
	public void writeIntoJsonFile_shouldReturnOne_whenScreenObjectGiven() throws IOException {
		Screen screen = new Screen(200, "screen2");
		int rowAffected = fileUtil.writeIntoJsonFile(screen);
		assertEquals(1, rowAffected);
	}

	@Test
	public void readFromJsonFile_shouldReturnOne_whenScreenObjectGiven() {
		List<Screen> list = fileUtil.readFromJsonFile();
		for (Screen screen : list) {
			System.out.println(screen.getScreenName());
		}
	}

}
