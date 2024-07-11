package com.selimhorri.app.auth;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class CredentialRepository implements PanacheRepositoryBase<Credential, Integer> {
	
	public Optional<Credential> findByUsername(final String username) {
		return find("""
					SELECT c
					FROM Credential c
					WHERE LOWER(c.username) = :username
					""", Parameters.with("username", username))
				.firstResultOptional();
	}
	
}



