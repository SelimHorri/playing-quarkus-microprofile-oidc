package com.selimhorri.app.auth.exception;

public final class ObjectNotFoundException extends GloabalException {
	
	public static final int HTTP_STATUS = 404;
	
	public ObjectNotFoundException(String message) {
		super(HTTP_STATUS, message);
	}
	
}



