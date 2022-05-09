package com.quintrix.james.JPADemo.exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	String displayMessage;
	
	String detailedMessage;

	public EmployeeNotFoundException(String displayMessage, String detailedMessage) {
		super();
		this.displayMessage = displayMessage;
		this.detailedMessage = detailedMessage;
	}

	public EmployeeNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
