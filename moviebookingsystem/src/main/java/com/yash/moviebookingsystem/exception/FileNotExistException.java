package com.yash.moviebookingsystem.exception;

import java.io.FileNotFoundException;

public class FileNotExistException extends RuntimeException{
	public FileNotExistException(String exception) {
		super(exception);
	}
}
