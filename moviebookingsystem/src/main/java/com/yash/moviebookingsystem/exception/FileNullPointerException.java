package com.yash.moviebookingsystem.exception;

/**
 * This class is a custom Exception class to handle file null pointer exceptions
 * 
 * @author sahoo.manas
 * 
 */
public class FileNullPointerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3512801374422319749L;

	public FileNullPointerException(String exception) {
		super(exception);
	}
}
