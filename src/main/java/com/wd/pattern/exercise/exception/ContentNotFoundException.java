package com.wd.pattern.exercise.exception;

public class ContentNotFoundException extends Exception {


	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public static ContentNotFoundException createWith(String username) {
		return new ContentNotFoundException(username);
	}

	public ContentNotFoundException(String errormessage) {
		this.errorMessage = errormessage;
	}

	@Override
	public String getMessage() {
		return "SmartMeter Id "
				+ "'" + errorMessage + "' not found";
	}
}
