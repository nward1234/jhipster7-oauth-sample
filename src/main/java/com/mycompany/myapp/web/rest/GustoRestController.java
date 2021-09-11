package com.mycompany.myapp.web.rest;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

import com.mycompany.myapp.models.CurrentUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class GustoRestController {

    private final Logger log = LoggerFactory.getLogger(GustoRestController.class);

    @Value("${gusto-api.current-user-endpoint}")
    private String currentUserEndpoint;

    @Value("${gusto-api.employees-endpoint}")
    private String employeesEndpoint;

    @Autowired
    private WebClient webClient;

    public GustoRestController() {}

    @GetMapping(value = "/gusto-token")
    public String gustoToken(@RegisteredOAuth2AuthorizedClient("gusto") OAuth2AuthorizedClient gustoAuthorizedClient) {
        log.debug("Gusto Access Token: {}", gustoAuthorizedClient.getAccessToken().getTokenValue());

        return gustoAuthorizedClient.getAccessToken().getTokenValue();
    }

    @GetMapping(value = "/gusto-current-user")
    public ResponseEntity<CurrentUserResponse> getCurrentUser(
        @RegisteredOAuth2AuthorizedClient("gusto") OAuth2AuthorizedClient gustoAuthorizedClient
    ) {
        log.debug("Gusto Access Token: {}", gustoAuthorizedClient.getAccessToken().getTokenValue());

        ResponseEntity<CurrentUserResponse> response =
            this.webClient.get()
                .uri(this.currentUserEndpoint)
                .attributes(clientRegistrationId("gusto"))
                .retrieve()
                .toEntity(CurrentUserResponse.class)
                .block();
        log.debug("Got HTTP Response!");
        CurrentUserResponse currentUser = response.getBody();
        log.info("Current User: {}", currentUser.toString());

        return response;
    }
}
