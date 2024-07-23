package com.selimhorri.app.credential.application;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(registerFullHierarchy = true)
public record LoginResponse(String accessToken) {}



