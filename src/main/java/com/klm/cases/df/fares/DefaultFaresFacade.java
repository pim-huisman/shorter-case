package com.klm.cases.df.fares;

import com.klm.cases.df.locations.Location;
import com.klm.cases.df.locations.LocationsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class DefaultFaresFacade implements FaresFacade {

    private final FaresService faresService;

    private final LocationsService locationsService;

    public DefaultFaresFacade(FaresService faresService, LocationsService locationsService) {
        this.faresService = faresService;
        this.locationsService = locationsService;
    }

    @Override
    public Fare calculateFare(String origin, String destination, String currency) {
        try {
            return faresService.calculateFare(origin, destination, currency);
        } catch (HttpClientErrorException httpException) {
            // TODO: test coverage
            final HttpStatus statusCode = httpException.getStatusCode();
            if (statusCode == HttpStatus.BAD_REQUEST || statusCode == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("Fare not available");
            } else {
                throw new RuntimeException(httpException.getMessage());
            }
        }
    }

    // TODO: test coverage
    // TODO: Parallelise API calls
    @Override
    public DetailedFare calculateDetailedFare(String origin, String destination, String currency) {
        Fare fare = calculateFare(origin, destination, currency);
        Location originLocation = locationsService.get(origin);
        Location destinationLocation = locationsService.get(origin);
        return new DetailedFare(fare, originLocation, destinationLocation);
    }
}
