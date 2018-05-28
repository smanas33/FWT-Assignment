package com.yash.moviebookingsystem.exception;

/**
 * This class is a custom Exception class for show class to handle null pointer
 * exception for show object
 * 
 * @author sahoo.manas
 * 
 */
public class ShowNullPointerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -682184699057225453L;

	public ShowNullPointerException(String exception) {
		super(exception);
	}
}
