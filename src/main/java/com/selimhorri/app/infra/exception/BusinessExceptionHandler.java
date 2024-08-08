package com.selimhorri.app.infra.exception;

import com.selimhorri.app.ApiPayload;
import com.selimhorri.app.ApiStatus;
import io.quarkus.runtime.annotations.RegisterForReflection;
import io.vertx.ext.web.RoutingContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@RegisterForReflection(registerFullHierarchy = true)
@Provider
@Slf4j
@RequiredArgsConstructor
class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {
	
	@Context
	private final RoutingContext routingContext;
	
	@Override
	public Response toResponse(BusinessException e) {
		return switch (e) {
			case ObjectNotFoundException onf -> this.response(onf.getStatus(), onf.getMessage(), onf.getClass());
			case ObjectAlreadyExistsException oae -> this.response(oae.getStatus(), oae.getMessage(), oae.getClass());
		};
	}
	
	private Response response(int status, String detail, Class<? extends BusinessException> clazz) {
		var pd = ProblemDetail.forStatusAndDetail(status, detail);
		pd.setInstance(URI.create(this.routingContext.request().absoluteURI()).toString());
		pd.addProperty("exception", clazz.getSimpleName());
		log.error(pd.toString());
		log.error("{}", detail);
		return Response.status(status)
				.entity(new ApiPayload<ProblemDetail>(ApiStatus.FAILURE, pd))
				.build();
	}
	
}



