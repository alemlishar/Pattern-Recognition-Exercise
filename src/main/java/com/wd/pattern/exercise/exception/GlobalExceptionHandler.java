package com.wd.pattern.exercise.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.WebUtils;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class GlobalExceptionHandler {

	/** 
	 * Provides handling for exceptions throughout this service. 
	 * 
	 */
	@ExceptionHandler({ ContentNotFoundException.class, InvalidArgument.class , ContentCreationException.class})
	public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		if (ex instanceof ContentNotFoundException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			ContentNotFoundException unfe = (ContentNotFoundException) ex;

			return handleUserNotFoundException(unfe, headers, status, request);
		} else if (ex instanceof InvalidArgument) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			InvalidArgument cnae = (InvalidArgument) ex;

			return handleContentNotAllowedException(cnae, headers, status, request);
		} else if (ex instanceof ContentCreationException) {
			HttpStatus status = HttpStatus.OK;
			ContentCreationException cnae = (ContentCreationException) ex;

			return handleContentCreationException(cnae, headers, status, request);
		}
		else {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, null, headers, status, request);
		}
	}

	/** 
	 * 
	 * Customize the response for UserNotFoundException. 
	 */
	protected ResponseEntity<ApiError> handleUserNotFoundException(ContentNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = Collections.singletonList(ex.getMessage());
		return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
	}

	/** 
	 * Customize the response for ContentNotAllowedException(404).
	 * 
	 */
	protected ResponseEntity<ApiError> handleContentNotAllowedException(InvalidArgument ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getErrors()
				.stream()
				.map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
				.collect(Collectors.toList());

		return handleExceptionInternal(ex, new ApiError(errorMessages), headers, status, request);
	}

	/** 
	 * Customize the response for ContentCreationException (201).
	 * 
	 */
	protected ResponseEntity<ApiError> handleContentCreationException(ContentCreationException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getErrors()
				.stream()
				.map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
				.collect(Collectors.toList());

		return handleExceptionInternal(ex, new ApiError(errorMessages), headers, status, request);
	}

	/**
	 *  
	 * A single place to customize the response body of all Exception type(500)
	 */
	protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		return new ResponseEntity<>(body, headers, status);
	}
}