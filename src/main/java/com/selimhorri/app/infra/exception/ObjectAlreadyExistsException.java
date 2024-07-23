package com.selimhorri.app.infra.exception;

import jakarta.ws.rs.core.Response.Status;

public final class ObjectAlreadyExistsException extends BusinessException {
	
	public static final Status HTTP_STATUS = Status.CONFLICT;
	
	public ObjectAlreadyExistsException(String message) {
		super(HTTP_STATUS, message);
	}
	
}



