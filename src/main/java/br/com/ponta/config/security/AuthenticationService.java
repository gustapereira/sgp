package br.com.ponta.config.security;

import br.com.ponta.domain.Usuario;
import br.com.ponta.service.UsuarioService;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class AuthenticationService {

    public final static String DIAGNOSTICO_ADMIN = "AGRO_DIAGNOSTICO_ADMIN";
    public final static String PUSH_ADMIN = "AGRO_ADMIN";
    public final static String PUSH_GESTOR = "AGRO_GESTOR";
    private static final String CLAIM_CPF = "cpf";
    @Autowired
    private KeycloakConfig keyCloak;
    @Autowired
    private UsuarioService usuarioService;

    public Usuario getUsuarioLogado() {
        Usuario usuario = usuarioService.recuperaOuCriaUsuarioNaBaseCasoNaoExista(getLogin(), getNome(), getCpf());
        return usuario;
    }

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
