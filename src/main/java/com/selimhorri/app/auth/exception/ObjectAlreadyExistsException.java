package com.selimhorri.app.auth.exception;

public non-sealed class ObjectAlreadyExistsException extends GloabalException {
	
	public static final int HTTP_STATUS = 409; // CONFLICT
	
	public ObjectAlreadyExistsException(String message) {
		super(HTTP_STATUS, message);
	}
	
}



