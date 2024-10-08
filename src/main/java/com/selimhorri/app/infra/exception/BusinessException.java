package com.selimhorri.app.infra.exception;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.core.Response.Status;
import lombok.Getter;

@RegisterForReflection(registerFullHierarchy = true)
@Getter
public abstract sealed class BusinessException 
				extends RuntimeException
				permits ObjectNotFoundException, ObjectAlreadyExistsException {
	
	private final int status;
	private final String message;
	
	protected BusinessException(Status status, String message) {
		super(message);
		this.status = status.getStatusCode();
		this.message = message;
	}
	
	protected BusinessException(String message) {
		super(message);
		this.status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		this.message = message;
	}
	
}



