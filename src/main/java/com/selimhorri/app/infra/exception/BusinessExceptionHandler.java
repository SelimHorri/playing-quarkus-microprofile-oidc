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
			// case CredentialNotFoundException cnf -> this.response(cnf.getStatus(), cnf.getMessage(), e); 
			case ObjectNotFoundException onf -> this.response(onf.getStatus(), onf.getMessage(), e);
			case ObjectAlreadyExistsException oae -> this.response(oae.getStatus(), oae.getMessage(), e);
			// case BusinessException be -> this.response(be.getStatus(), be.getMessage(), e);
		};
	}
	
	private Response response(int status, String detail, RuntimeException e) {
		var pd = ProblemDetail.forStatusAndDetail(status, detail);
		pd.setInstance(URI.create(this.routingContext.request().absoluteURI()).toString());
		pd.addProperty("exception", e.getClass().getSimpleName());
		log.error(pd.toString());
		log.error("{}", e.getMessage());
		return Response.status(status)
				.entity(new ApiPayload<ProblemDetail>(ApiStatus.FAILURE, pd))
				.build();
	}
	
}



