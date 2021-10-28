package com.wd.pattern.exercise.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ContentCreationException extends  Exception{

	private static final long serialVersionUID = 5894731492906754673L;
	List<ObjectError> errors;

	public static ContentCreationException createWith(List<ObjectError> errors) {
		return new ContentCreationException(errors);
	}

	private ContentCreationException(List<ObjectError> errors) {
		this.errors = errors;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}
}
