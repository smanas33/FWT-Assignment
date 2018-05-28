package com.yash.moviebookingsystem.exception;

/**
 * This class is a custom Exception class to handle empty file exceptions
 * 
 * @author sahoo.manas
 * 
 */
public class FileEmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9211569703963470424L;

	public FileEmptyException(String exception) {
		super(exception);
	}
}
