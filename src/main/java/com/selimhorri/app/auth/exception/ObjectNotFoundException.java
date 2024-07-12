package com.selimhorri.app.auth.exception;

public sealed class ObjectNotFoundException extends GloabalException permits CredentialNotFoundException {
	
	public static final int HTTP_STATUS = 404;
	
	public ObjectNotFoundException(String message) {
		super(HTTP_STATUS, message);
	}
	
}



