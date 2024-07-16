package com.selimhorri.app.auth.exception;

import jakarta.ws.rs.core.Response.Status;

public non-sealed class ObjectAlreadyExistsException extends BusinessException {
	
	public static final Status HTTP_STATUS = Status.CONFLICT;
	
	public ObjectAlreadyExistsException(String message) {
		super(HTTP_STATUS, message);
	}
	
}



