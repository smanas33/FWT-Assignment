package com.yash.moviebookingsystem.exception;

/**
 * This class is a custom Exception class for Screen class to handle null
 * pointer exception for Screen object
 * 
 * @author sahoo.manas
 * 
 */
public class ScreenNullPointerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4356553501909091594L;

	public ScreenNullPointerException(String exception) {
		super(exception);
	}
}
