package com.selimhorri.app.auth.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.core.Response.Status;
import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RegisterForReflection(registerFullHierarchy = true)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Builder(access = AccessLevel.PRIVATE)
public class ProblemDetail {
	
	private String type;
	private String title;
	private int status;
	private String detail;
	private String instance;
	
	@JsonInclude(Include.NON_EMPTY)
	private final Map<String, Object> properties = new LinkedHashMap<>();
	
	public static ProblemDetail forStatus(int status) {
		return forStatus(Status.fromStatusCode(status));
	}
	
	public static ProblemDetail forStatus(Status status) {
		return forStatusAndDetail(status, null);
	}
	
	public static ProblemDetail forStatusAndDetail(int status, String detail) {
		return forStatusAndDetail(Status.fromStatusCode(status), detail);
	}
	
	public static ProblemDetail forStatusAndDetail(Status status, String detail) {
		return ProblemDetail.builder()
				.type("about:blank")
				.title(null)
				.status(status.getStatusCode())
				.detail(detail)
				.instance(null)
				.build();
	}
	
	public void addProperty(String key, Object value) {
		this.properties.put(key, value);
	}
	
}



