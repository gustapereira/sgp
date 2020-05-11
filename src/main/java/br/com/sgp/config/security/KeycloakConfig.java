package br.com.sgp.config.security;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.OAuth2Constants;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.security.Principal;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(KeycloakSpringBootProperties.class)
class KeycloakConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Value("${keycloak.auth-server-url}")
    String urlKeycloak;
    @Value("${keycloak.resource}")
    String clientId;
    @Value("${keycloak.realm}")
    String realm;
    @Value("${app.origin-permitida}")
    String[] origens;


    /**
     * The Keycloak Admin client that provides the service-account Access-Token
     *
     * @param props
     *
     * @return
     */
    @Bean
    public Keycloak keycloak(KeycloakSpringBootProperties props) {
        return KeycloakBuilder.builder() //
            .serverUrl(props.getAuthServerUrl()) //
            .realm(props.getRealm()) //
            .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
            .clientId(props.getResource()) //
            .clientSecret((String) props.getCredentials().get("secret")) //
            .build();
    }

    /**
     * Use {@link KeycloakAuthenticationProvider}
     *
     * @param auth
     *
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        SimpleAuthorityMapper grantedAuthorityMapper = new SimpleAuthorityMapper();
        grantedAuthorityMapper.setPrefix("ROLE_");
        grantedAuthorityMapper.setConvertToUpperCase(true);

        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(grantedAuthorityMapper);

        auth.authenticationProvider(keycloakAuthenticationProvider);
    }


    /**
     * Load Keycloak configuration from application.properties or application.yml
     *
     * @return
     */
    @Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(
            new SessionRegistryImpl());
    }

    /**
     * Allows to inject requests scoped wrapper for {@link KeycloakSecurityContext}.
     * <p>
     * Returns the {@link KeycloakSecurityContext} from the Spring
     * {@link ServletRequestAttributes}'s {@link Principal}.
     * <p>
     * The principal must support retrieval of the KeycloakSecurityContext, so at
     * this point, only {@link KeycloakPrincipal} values and
     * {@link KeycloakAuthenticationToken} are supported.
     *
     * @return the current <code>KeycloakSecurityContext</code>
     */
    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public KeycloakSecurityContext provideKeycloakSecurityContext() {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Principal principal = attributes.getRequest().getUserPrincipal();
        if (principal == null) {
            return null;
        }

        if (principal instanceof KeycloakAuthenticationToken) {
            principal = Principal.class.cast(KeycloakAuthenticationToken.class.cast(principal).getPrincipal());
        }

        if (principal instanceof KeycloakPrincipal) {
            return KeycloakPrincipal.class.cast(principal).getKeycloakSecurityContext();
        }

        return null;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.anonymous().and()
            .authorizeRequests()
            .antMatchers("/",
                "/h2/*",
                "/lib/*",
                "/css/*",
                "/fonts/*",
                "/images/*",
                "/o2c.html",
                "index.html",
                "/webjars/**",
                "/api-docs/*",
                "/v1/api-docs",
                "/v2/api-docs",
                "/swagger-ui.js",
                "/swagger-ui.html",
                "/swagger-ui.min.js",
                "/swagger-resources/**",
                "/hystrix/**",
                "/atividade",
                "/atividade/**",
                "/propriedade",
                "/propriedade/**",
                "/noticias",
                "/noticias/**",
                "/push-notification",
                "/push-notification/**",
                "/uf/**",
                "/uf",
                "/usuario",
                "/usuario/**",
                "/praga",
                "/praga/**",
                "/falaSebrae",
                "/falaSebrae/**",
                "/lista_pragas",
                "/lista_pragas/**"
            ).permitAll()
            .anyRequest().authenticated().and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .csrf().disable()
            .headers().frameOptions().disable();
    }
}
