package com.yash.moviebookingsystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;
import org.mockito.Mockito;

import com.yash.operator.utils.OperatorUtils;

public class MovieMenuTest {

	@Test
	public void test() {
		
		     OperatorUtils utils = new OperatorUtils();
		     try {
				utils.out = Mockito.spy(new PrintStream("testFile1.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		     // mock a call with an expected input
		     doNothing().when(utils.out).println("expected command");

		     utils.getOperatorMenu();

		     // test that there was a call
		     Mockito.verify(utils.out, Mockito.times(1)).println("expected command");
	}

}
