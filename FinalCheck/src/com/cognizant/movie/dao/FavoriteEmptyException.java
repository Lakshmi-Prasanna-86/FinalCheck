package com.cognizant.movie.dao;

/**
 * @author prasanna
 */
@SuppressWarnings("serial")
public class FavoriteEmptyException extends Exception {
	private String message;

	public FavoriteEmptyException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
