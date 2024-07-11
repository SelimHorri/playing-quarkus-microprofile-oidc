package com.selimhorri.app.auth;

import com.selimhorri.app.auth.exception.ObjectAlreadyExistsException;
import com.selimhorri.app.auth.exception.ObjectNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Transactional
@Slf4j
@RequiredArgsConstructor
public class LoginService {
	
	private final CredentialRepository credentialRepository;
	
	public LoginResponse login(final LoginRequest loginRequest) {
		final var credential = this.credentialRepository
				.findByUsername(loginRequest.username())
				.orElseThrow(() -> new ObjectNotFoundException(
						"No Such emp credentials with username: " + loginRequest.username()));
		log.debug("==>> credential with username: {}", credential.getUsername());
		return new LoginResponse(null);
	}
	
}


