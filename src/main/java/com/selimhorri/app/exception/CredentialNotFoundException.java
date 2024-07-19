package com.selimhorri.app.exception;

public final class CredentialNotFoundException extends ObjectNotFoundException {
	
	public CredentialNotFoundException() {
		super("Credential is not found");
	}
	
	public CredentialNotFoundException(String message) {
		super(message);
	}
	
}



