package com.klm.cases.df.locations;

import com.klm.cases.df.commons.ApiProperties;
import com.klm.cases.df.commons.UriComponentsBuilderFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class DefaultLocationsService implements LocationsService {
    private static final ParameterizedTypeReference<PagedModel<EntityModel<Location>>> PAGED_LOCATIONS_TYPE = new ParameterizedTypeReference<>(){};

    private final RestTemplate restTemplate;

    private final ApiProperties properties;

    public DefaultLocationsService(RestTemplate restTemplate, ApiProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @Override
    public PagedModel<EntityModel<Location>> list() {
        // TODO: test coverage
        // TODO: Add paging support
        URI url = UriComponentsBuilderFactory.create().path(properties.locationsPath()).build().toUri();
        final ResponseEntity<PagedModel<EntityModel<Location>>> response = restTemplate.exchange(url, HttpMethod.GET, null, PAGED_LOCATIONS_TYPE);
        return response.getBody();
    }

    @Override
    public Location get(String key)  throws HttpClientErrorException {
        // TODO: test coverage
        URI url = UriComponentsBuilderFactory.create().path("/airports/").path(key).build().toUri();
        final ResponseEntity<Location> response = restTemplate.getForEntity(url, Location.class);
        return response.getBody();
    }

    @Override
    public PagedModel<EntityModel<Location>> search(String term) {
        // TODO: test coverage
        // TODO: Add paging support
        URI url = UriComponentsBuilderFactory.create().path(properties.locationsPath()).queryParam("lang").queryParam("term", term).build().toUri();
        final ResponseEntity<PagedModel<EntityModel<Location>>> response = restTemplate.exchange(url, HttpMethod.GET, null, PAGED_LOCATIONS_TYPE);
        return response.getBody();
    }
}
