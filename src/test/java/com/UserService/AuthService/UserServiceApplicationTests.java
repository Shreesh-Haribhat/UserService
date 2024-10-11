package com.UserService.AuthService;

import com.UserService.AuthService.Security.Repository.ClientRepository;
import com.UserService.AuthService.Security.Repository.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.test.annotation.Commit;

import java.util.UUID;

@SpringBootTest
class UserServiceApplicationTests {

	private JpaRegisteredClientRepository jpaRegisteredClientRepository;

	@Autowired
	public UserServiceApplicationTests(JpaRegisteredClientRepository jpaRegisteredClientRepository)
	{
		this.jpaRegisteredClientRepository = jpaRegisteredClientRepository;
	}

	@Test
	void contextLoads() {
	}

	@Test
	@Commit
	public void addToDb()
	{
		RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("oidc-client")
                .clientSecret("$2a$12$u.z0g4dekOp/CLmQp19anOMfqL1OtZl9Si5HdCdXTmEBgIOmFybH.")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("https://oauth.pstmn.io/v1/callback")
                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                .scope("ADMIN")
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                .build();

		jpaRegisteredClientRepository.save(oidcClient);
	}

}
