package com.selimhorri.app.auth;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(registerFullHierarchy = true)
public record LoginResponse(String accessToken) {}



