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
class ExceptionHandler implements ExceptionMapper<GloabalException> {
	
	@Override
	public Response toResponse(GloabalException e) {
		return switch (e) {
			// case null -> null;
			case ObjectNotFoundException onf -> response(onf.getStatus(), onf::getMessage);
			case ObjectAlreadyExistsException oae -> response(oae.getStatus(), oae::getMessage);
			default -> response(500, () -> "Service unavailable..");
		};
	}
	
	private static <T> Response response(int status, Supplier<T> supplier) {
		return Response.status(status)
				.entity(new ApiPayload<>(ApiStatus.FAILURE, supplier.get()))
				.build();
	}
	
}



