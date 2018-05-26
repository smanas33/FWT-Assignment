package com.yash.moviebookingsystem.operatormenutest;

import org.junit.Test;

import com.yash.moviebookingsystem.exception.FileNullPointerException;
import com.yash.moviebookingsystem.menu.utils.OperatorMenu;

public class OperatorMenuTest {

	@Test(expected = FileNullPointerException.class)
	public void shouldThrowFileNullPointerExcepTion_WhenNoFileNameGiven() {
		String fileName = null;
		OperatorMenu.chooseUserOption();;
	}

	@Test(expected = FileNullPointerException.class)
	public void shouldThrowEmptyFileExcepTion_WhenGivenFileNameIsEmpty() {
		String fileName = "";
		OperatorMenu.chooseUserOption();
	}

	@Test
	public void shouldThrowFileNotFoundExcepTion_WhenWrongFileNameGiven() {
		String fileName = "testFile1.tx";
		OperatorMenu.chooseUserOption();
	}

	@Test
	public void shouldNotThrowAnyException_WhenCorrectFileNameGiven() {		
		OperatorMenu.chooseUserOption();
	}

}
