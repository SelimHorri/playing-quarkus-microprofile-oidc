package com.selimhorri.app.credential.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(@NotBlank(message = "Username should not be blank") String username,
						   @NotBlank(message = "Password should not be blank")
						   @Size(min = 4, message = "Password should contain {min} at least") String password) {}



