package com.selimhorri.app.auth.exception;

import jakarta.ws.rs.core.Response.Status;
import lombok.Getter;

@Getter
public abstract sealed class BusinessException 
				extends RuntimeException
				permits ObjectNotFoundException, ObjectAlreadyExistsException {
	
	private final int status;
	private final String message;
	
	public BusinessException(Status status, String message) {
		super(message);
		this.status = status.getStatusCode();
		this.message = message;
	}
	
	public BusinessException(String message) {
		super(message);
		this.status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		this.message = message;
	}
	
}



