package com.selimhorri.app.auth;

import com.selimhorri.app.ApiPayload;
import com.selimhorri.app.ApiStatus;
import com.selimhorri.app.auth.exception.GloabalException;
import com.selimhorri.app.auth.exception.ObjectAlreadyExistsException;
import com.selimhorri.app.auth.exception.ObjectNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.function.Supplier;

@Provider
public class ExceptionHandler implements ExceptionMapper<GloabalException> {
	
	@Override
	public Response toResponse(GloabalException e) {
		return switch (e) {
			case ObjectNotFoundException onf -> response(onf.getStatus(), () -> new ApiPayload<>(ApiStatus.FAILURE, onf.getMessage()));
			case ObjectAlreadyExistsException oae -> response(oae.getStatus(), () -> new ApiPayload<>(ApiStatus.FAILURE, oae.getMessage()));
			default -> response(500, () -> new ApiPayload<>(ApiStatus.FAILURE, "Service unavailable.."));
		};
	}
	
	private static Response response(int status, Supplier<? super ApiPayload<?>> supplier) {
		return Response.status(status)
				.entity(supplier.get())
				.build();
	}
	
}



