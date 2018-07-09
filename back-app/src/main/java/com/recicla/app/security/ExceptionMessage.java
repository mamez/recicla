package com.recicla.app.security;

public class ExceptionMessage {
	private String message;
	
	public ExceptionMessage(Throwable throwable) {
		this.message=throwable.getMessage();
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
