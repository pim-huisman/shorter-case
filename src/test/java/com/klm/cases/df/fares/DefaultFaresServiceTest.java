package com.klm.cases.df.fares;

import com.klm.cases.df.commons.ApiProperties;
import com.klm.cases.df.commons.UriComponentsBuilderFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultFaresServiceTest {
    private static final URI FARE_URI = UriComponentsBuilderFactory.create().path("/fares/").path("BUD").path("/").path("SZG").queryParam("currency", "USD").build().toUri();
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ApiProperties properties;

    @InjectMocks
    private DefaultFaresService underTest;

    private final ResponseEntity<Fare> mockFareResponse = ResponseEntity.ok(new Fare(1000, "USD", "BUD", "SZG"));

    @BeforeEach
    void setUp() {
        when(restTemplate.getForEntity(FARE_URI, Fare.class)).thenReturn(mockFareResponse);

        when(properties.faresPath()).thenReturn("fares");
    }

    @Test
    void testCalculateFareShouldCallRestTemplate() {
        // GIVEN
        String origin = "BUD";
        String destination = "SZG";
        String currency = "USD";

        // WHEN
        underTest.calculateFare(origin, destination, currency);

        // THEN
        verify(restTemplate).getForEntity(FARE_URI, Fare.class);
    }
}