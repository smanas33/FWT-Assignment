package com.yash.moviebookingsystem.exception;

/**
 * This class is a custom Exception class for Movie class to handle null pointer
 * exception for movie object
 * 
 * @author sahoo.manas
 * 
 */
public class MovieNullPointerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4126350408385875283L;

	public MovieNullPointerException(String exception) {
		super(exception);
	}

}
