package com.wd.pattern.exercise.exception;

public class HttpMessageNotReadableException extends Exception{

	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public static HttpMessageNotReadableException createWith(String errorMessage) {
		return new HttpMessageNotReadableException(errorMessage);
	}

	public HttpMessageNotReadableException(String errormessage) {
		this.errorMessage = errormessage;
	}

	@Override
	public String getMessage() {
		return "Error Id "
				+ "'" + errorMessage + "' not found";
	}
	
}
