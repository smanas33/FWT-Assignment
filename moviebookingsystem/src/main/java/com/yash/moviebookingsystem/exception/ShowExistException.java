package com.yash.moviebookingsystem.exception;

/**
 * This class is a custom Exception class for Show class to handle exist Show
 * object exception for show
 * 
 * @author sahoo.manas
 * 
 */
public class ShowExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7967138394651994687L;

	public ShowExistException(String exception) {
		super(exception);
	}
}
