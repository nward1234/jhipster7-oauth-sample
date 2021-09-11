/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycompany.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author nathanward
 *
 * @see https://docs.spring.io/spring-security/site/docs/current/reference/html5/#oauth2client
 *
 * The ClientRegistration class representation of a client registered with an OAuth 2.0 or OpenID Connect 1.0 Provider.
 * A client registration holds information, such as client id, client secret, authorization grant type, redirect URI, scope(s), authorization URI, token URI, and other details.
 *
 *
 */
@Configuration
public class WebClientConfig {

    @Bean
    WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client = new ServletOAuth2AuthorizedClientExchangeFilterFunction(
            authorizedClientManager
        );

        oauth2Client.setDefaultClientRegistrationId("gusto");
        oauth2Client.setDefaultOAuth2AuthorizedClient(false);

        return WebClient.builder().apply(oauth2Client.oauth2Configuration()).filter(WebClientFilter.logRequest()).build();
    }

    /**
   * 
   * The ClientRegistrationRepository serves as a repository for OAuth 2.0 / OpenID Connect 1.0 ClientRegistration(s).
   * The default implementation of ClientRegistrationRepository is InMemoryClientRegistrationRepository.
   * 
   * The OAuth2AuthorizedClientManager is responsible for the overall management of OAuth2AuthorizedClient(s).

      The primary responsibilities include:
      
      Authorizing (or re-authorizing) an OAuth 2.0 Client, using an OAuth2AuthorizedClientProvider.
      
      Delegating the persistence of an OAuth2AuthorizedClient, typically using an OAuth2AuthorizedClientService or OAuth2AuthorizedClientRepository.
      
      Delegating to an OAuth2AuthorizationSuccessHandler when an OAuth 2.0 Client has been successfully authorized (or re-authorized).
      
      Delegating to an OAuth2AuthorizationFailureHandler when an OAuth 2.0 Client fails to authorize (or re-authorize).
      
      An OAuth2AuthorizedClientProvider implements a strategy for authorizing (or re-authorizing) an OAuth 2.0 Client. Implementations will typically implement an authorization grant type, eg. authorization_code, client_credentials, etc.
      
      The default implementation of OAuth2AuthorizedClientManager is DefaultOAuth2AuthorizedClientManager, which is associated with an OAuth2AuthorizedClientProvider that may support multiple authorization grant types using a delegation-based composite. The OAuth2AuthorizedClientProviderBuilder may be used to configure and build the delegation-based composite.

   * @param clientRegistrationRepository
   * @param authorizedClientRepository
   * @return
   */
    @Bean
    OAuth2AuthorizedClientManager authorizedClientManager(
        ClientRegistrationRepository clientRegistrationRepository,
        OAuth2AuthorizedClientRepository authorizedClientRepository
    ) {
        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder
            .builder()
            .authorizationCode()
            .refreshToken()
            .build();

        // use the Default OAuth2 Authorized Client Manager as the authorized client manager.
        DefaultOAuth2AuthorizedClientManager authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(
            clientRegistrationRepository,
            authorizedClientRepository
        );

        // Configure the Authorized Client Manager with the Authorized Client Provider
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

        return authorizedClientManager;
    }
}
