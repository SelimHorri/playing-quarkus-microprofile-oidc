package com.selimhorri.app.auth.exception;

import jakarta.ws.rs.core.Response.Status;

public sealed class ObjectNotFoundException extends BusinessException permits CredentialNotFoundException {
	
	public static final Status HTTP_STATUS = Status.NOT_FOUND;
	
	public ObjectNotFoundException(String message) {
		super(HTTP_STATUS, message);
	}
	
}



