package com.selimhorri.app.auth.exception;

public final class ObjectAlreadyExistsException extends GloabalException {
	
	public static final int HTTP_STATUS = 409;
	
	public ObjectAlreadyExistsException(String message) {
		super(HTTP_STATUS, message);
	}
	
}



