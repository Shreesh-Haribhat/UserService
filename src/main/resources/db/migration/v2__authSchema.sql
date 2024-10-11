CREATE TABLE client (
                        id varchar(255) NOT NULL,
                        clientId varchar(255) NOT NULL,
                        clientIdIssuedAt timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                        clientSecret varchar(255) DEFAULT NULL,
                        clientSecretExpiresAt timestamp DEFAULT NULL,
                        clientName varchar(255) NOT NULL,
                        clientAuthenticationMethods varchar(1000) NOT NULL,
                        authorizationGrantTypes varchar(1000) NOT NULL,
                        redirectUris varchar(1000) DEFAULT NULL,
                        postLogoutRedirectUris varchar(1000) DEFAULT NULL,
                        scopes varchar(1000) NOT NULL,
                        clientSettings varchar(2000) NOT NULL,
                        tokenSettings varchar(2000) NOT NULL,
                        PRIMARY KEY (id)
);


CREATE TABLE authorization (
                               id varchar(255) NOT NULL,
                               registeredClientId varchar(255) NOT NULL,
                               principalName varchar(255) NOT NULL,
                               authorizationGrantType varchar(255) NOT NULL,
                               authorizedScopes TEXT DEFAULT NULL,
                               attributes TEXT DEFAULT NULL,
                               state TEXT DEFAULT NULL,
                               authorizationCodeValue TEXT DEFAULT NULL,
                               authorizationCodeIssuedAt timestamp DEFAULT NULL,
                               authorizationCodeExpiresAt timestamp DEFAULT NULL,
                               authorizationCodeMetadata TEXT DEFAULT NULL,
                               accessTokenValue TEXT DEFAULT NULL,
                               accessTokenIssuedAt timestamp DEFAULT NULL,
                               accessTokenExpiresAt timestamp DEFAULT NULL,
                               accessTokenMetadata TEXT DEFAULT NULL,
                               accessTokenType TEXT DEFAULT NULL,
                               accessTokenScopes TEXT DEFAULT NULL,
                               refreshTokenValue TEXT DEFAULT NULL,
                               refreshTokenIssuedAt timestamp DEFAULT NULL,
                               refreshTokenExpiresAt timestamp DEFAULT NULL,
                               refreshTokenMetadata TEXT DEFAULT NULL,
                               oidcIdTokenValue TEXT DEFAULT NULL,
                               oidcIdTokenIssuedAt timestamp DEFAULT NULL,
                               oidcIdTokenExpiresAt timestamp DEFAULT NULL,
                               oidcIdTokenMetadata TEXT DEFAULT NULL,
                               oidcIdTokenClaims TEXT DEFAULT NULL,
                               userCodeValue TEXT DEFAULT NULL,
                               userCodeIssuedAt timestamp DEFAULT NULL,
                               userCodeExpiresAt timestamp DEFAULT NULL,
                               userCodeMetadata TEXT DEFAULT NULL,
                               deviceCodeValue TEXT DEFAULT NULL,
                               deviceCodeIssuedAt timestamp DEFAULT NULL,
                               deviceCodeExpiresAt timestamp DEFAULT NULL,
                               deviceCodeMetadata TEXT DEFAULT NULL,
                               PRIMARY KEY (id)
);


CREATE TABLE authorizationConsent (
                                      registeredClientId varchar(255) NOT NULL,
                                      principalName varchar(255) NOT NULL,
                                      authorities varchar(1000) NOT NULL,
                                      PRIMARY KEY (registeredClientId, principalName)
);