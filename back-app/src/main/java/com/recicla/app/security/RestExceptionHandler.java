package com.recicla.app.security;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class RestExceptionHandler {

	 private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
	 
	    @ExceptionHandler({ Exception.class,JobGreenExeption.class})
	    @ResponseBody
	    public ResponseEntity<?> handleAnyException(Exception e) {
	        return errorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    @ExceptionHandler({ JobGreenSecurityExeption.class,ServletException.class })
	    @ResponseBody
	    public ResponseEntity<?> JobGreenSecurityExeption(JobGreenSecurityExeption e) {
	        return errorResponse(e, HttpStatus.UNAUTHORIZED);
	    }
	    
	    /**
	     * Handle failures commonly thrown from code
	     */
	    @ExceptionHandler({ InvocationTargetException.class, IllegalArgumentException.class, ClassCastException.class,
	            ConversionFailedException.class })
	    @ResponseBody
	    public ResponseEntity<?> handleMiscFailures(Throwable t) {
	        return errorResponse(t, HttpStatus.BAD_REQUEST);
	    }

	    /**
	     * Send a 409 Conflict in case of concurrent modification
	     */
	    @ExceptionHandler({ ObjectOptimisticLockingFailureException.class, OptimisticLockingFailureException.class,
	            DataIntegrityViolationException.class })
	    @ResponseBody
	    public ResponseEntity<?> handleConflict(Exception ex) {
	        return errorResponse(ex, HttpStatus.CONFLICT);
	    }
	    
	    @ExceptionHandler({MethodArgumentNotValidException.class})
	    public ResponseEntity<ExceptionMessage> invalidInput(MethodArgumentNotValidException ex) {
	        ExceptionMessage response = new ExceptionMessage(ex);
	        return new ResponseEntity<ExceptionMessage>(response, HttpStatus.BAD_REQUEST);
	    }
	    
	    protected ResponseEntity<ExceptionMessage> errorResponse(Throwable throwable, HttpStatus status) {
	    		if (null != throwable) {
	    				log.error("error caught: " + throwable.getMessage(), throwable);
	    				return response(new ExceptionMessage(throwable), status);
	    		} else {
	    				log.error("unknown error caught in RESTController, {}", status);
	    				return response(null, status);
	    		}
	    }
	 
	    protected <T> ResponseEntity<T> response(T body, HttpStatus status) {
	        log.debug("Responding with a status of {}", status);
	        return new ResponseEntity<>(body, new HttpHeaders(), status);
	    }
	
}
