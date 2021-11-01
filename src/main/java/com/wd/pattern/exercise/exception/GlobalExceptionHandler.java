package com.wd.pattern.exercise.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.WebUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class GlobalExceptionHandler {

	/** 
	 * Provides handling for exceptions throughout this service. 
	 * 
	 */
	@ExceptionHandler({ ContentNotFoundException.class, InvalidArgument.class , ContentCreationException.class, HttpMessageNotReadableException.class,
		
	})
	public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		if (ex instanceof ContentNotFoundException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			ContentNotFoundException unfe = (ContentNotFoundException) ex;

			return handleUserNotFoundException(unfe, headers, status, request);
		} /*else if (ex instanceof InvalidArgument) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			InvalidArgument cnae = (InvalidArgument) ex;

			return handleContentNotAllowedException(cnae, headers, status, request);
		} */else if (ex instanceof ContentCreationException) {
			HttpStatus status = HttpStatus.OK;
			ContentCreationException cnae = (ContentCreationException) ex;

			return handleContentCreationException(cnae, headers, status, request);
		}else if(ex instanceof HttpMessageNotReadableException) {

			HttpStatus status = HttpStatus.BAD_REQUEST;
			HttpMessageNotReadableException cnae = (HttpMessageNotReadableException) ex;

			return HttpMessageNotReadableException(cnae, headers, status, request);
		}
		/*else if(ex instanceof MethodArgumentNotValidException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			MethodArgumentNotValidException cnae = (MethodArgumentNotValidException) ex;

			return MethodArgumentNotValidException(cnae, headers, status, request);		
		}*/
		else {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, null, headers, status, request);
		}
	}


/*
	protected ResponseEntity<ApiError> MethodArgumentNotValidException(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = Collections.singletonList(ex.getMessage());
		return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
	}
*/

	/**
	 * 
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	protected ResponseEntity<ApiError> HttpMessageNotReadableException(HttpMessageNotReadableException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = Collections.singletonList(ex.getMessage());
		return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
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
	
	protected ResponseEntity<ApiError> handleContentNotAllowedException(InvalidArgument ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getErrors()
				.stream()
				.map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
				.collect(Collectors.toList());

		return handleExceptionInternal(ex, new ApiError(errorMessages), headers, status, request);
	}
 */
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
	 * A single place to customize the response body of all Exception type
	 */
	protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		return new ResponseEntity<>(body, headers, status);
	}
	
//	@ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }
	
	 private Error processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
	        Error error = new Error(400, "validation error");
	        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
	            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
	        }
	        return error;
	    }
	 
	 static class Error {
	        private final int status;
	        private final String message;
	        private List<FieldError> fieldErrors = new ArrayList<>();

	        Error(int status, String message) {
	            this.status = status;
	            this.message = message;
	        }

	        public int getStatus() {
	            return status;
	        }

	        public String getMessage() {
	            return message;
	        }

	        public void addFieldError(String path, String message) {
	            FieldError error = new FieldError(path, message, message);
	            fieldErrors.add(error);
	        }

	        public List<FieldError> getFieldErrors() {
	            return fieldErrors;
	        }
	    }
	
}