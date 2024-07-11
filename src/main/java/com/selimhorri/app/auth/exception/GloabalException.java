package com.selimhorri.app.auth.exception;

import lombok.Getter;

@Getter
public sealed class GloabalException 
		extends RuntimeException
		permits ObjectNotFoundException, ObjectAlreadyExistsException {
	
	private final int status;
	private final String message;
	
	public GloabalException(int status, String message) {
		super(message);
		this.status = status;
		this.message = message;
	}
	
	public GloabalException(String message) {
		super(message);
		this.status = 500;
		this.message = message;
	}
	
}



