package com.klm.cases.df.fares;

import com.klm.cases.df.commons.ApiProperties;
import com.klm.cases.df.commons.UriComponentsBuilderFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class DefaultFaresService implements FaresService {
    private final RestTemplate restTemplate;

    private final ApiProperties properties;

    public DefaultFaresService(RestTemplate restTemplate, ApiProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @Override
    public Fare calculateFare(String origin, String destination, String currency) throws HttpClientErrorException {
        URI url = UriComponentsBuilderFactory.create().path(properties.faresPath()).path("/").path(origin).path("/").path(destination).queryParam("currency", currency).build().toUri();
        final ResponseEntity<Fare> response = restTemplate.getForEntity(url, Fare.class);
        return response.getBody();
    }
}
