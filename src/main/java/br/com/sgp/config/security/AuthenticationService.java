package br.com.sgp.config.security;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class AuthenticationService {

    private static final String CLAIM_CPF = "cpf";
    @Autowired
    private KeycloakConfig keyCloak;

    private String getLogin() {
        return getKeycloakPrincipal().getToken().getPreferredUsername();
    }

    private String getNome() {
        return getKeycloakPrincipal().getToken().getName();
    }

    private String getCpf() {
        Map<String, Object> otherClaims = getKeycloakPrincipal().getToken().getOtherClaims();
        if (otherClaims.containsKey(CLAIM_CPF)) {
            return String.valueOf(otherClaims.get(CLAIM_CPF));
        }
        return null;
    }

    private KeycloakSecurityContext getKeycloakPrincipal() {
        KeycloakSecurityContext security = keyCloak.provideKeycloakSecurityContext();
        return security;
    }

    public boolean hasRole(String role) {
        AccessToken.Access access = getKeycloakPrincipal().getToken().getRealmAccess();
        Set<String> roles = access.getRoles();
        if (roles == null || roles.isEmpty()) {
            return false;
        } else {
            return roles.contains(role);
        }
    }
}
