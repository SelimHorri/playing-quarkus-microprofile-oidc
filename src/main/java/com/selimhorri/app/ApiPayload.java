package com.selimhorri.app;

public record ApiPayload<T>(ApiStatus status, T data) {}



