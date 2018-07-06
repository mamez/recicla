package edu.recicla.app.webapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class SecurityExeption extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SecurityExeption() {
        super();
    }
    public SecurityExeption(String message, Throwable cause) {
        super(message, cause);
    }
    public SecurityExeption(String message) {
        super(message);
    }
    public SecurityExeption(Throwable cause) {
        super(cause);
    }

}
