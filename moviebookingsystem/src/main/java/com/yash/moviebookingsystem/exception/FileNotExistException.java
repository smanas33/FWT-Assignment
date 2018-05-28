package com.yash.moviebookingsystem.exception;

/**
 * This class is a custom Exception class to handle non existing file exceptions
 * 
 * @author sahoo.manas
 * 
 */
public class FileNotExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8109771164176925108L;

	public FileNotExistException(String exception) {
		super(exception);
	}
}
