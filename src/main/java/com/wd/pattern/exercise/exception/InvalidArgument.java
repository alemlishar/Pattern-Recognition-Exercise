package com.wd.pattern.exercise.exception;
import java.util.List;

import org.springframework.validation.ObjectError;

public class InvalidArgument  extends Exception {

	private static final long serialVersionUID = 1L;
	List<ObjectError> errors;

	public InvalidArgument() {

	}
	public static InvalidArgument createWith(List<ObjectError> errors) {
		return new InvalidArgument(errors);
	}

	public InvalidArgument(List<ObjectError> errors) {
		this.errors = errors;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public String getError(Object obj) { 
		return "Invalid Argument" +  obj;
	}


}
