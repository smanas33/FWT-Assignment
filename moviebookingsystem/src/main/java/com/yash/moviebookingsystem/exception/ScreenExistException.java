package com.yash.moviebookingsystem.exception;

/**
 * This class is a custom Exception class for Screen class to handle object not
 * exist exception for screen
 * 
 * @author sahoo.manas
 * 
 */
public class ScreenExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8771938190349666766L;

	public ScreenExistException(String exception) {
		super(exception);
	}
}
