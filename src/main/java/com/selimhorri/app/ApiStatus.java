package com.selimhorri.app;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApiStatus {
	
	SUCCESS("success"),
	FAILURE("failure");
	
	private final String status;
	
	@JsonValue
	public String getStatus() {
		return status;
	}
	
}



