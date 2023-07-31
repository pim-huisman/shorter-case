package com.klm.cases.df.fares;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fares")
public class FaresController {
    private final FaresFacade facade;

    public FaresController(FaresFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/{origin}/{destination}")
    public HttpEntity<Fare> calculateFare(@PathVariable("origin") final String origin,
                                          @PathVariable("destination") final String destination,
                                          @RequestParam(value = "currency", defaultValue = "EUR") final String currency) {

        Fare result = facade.calculateFare(origin, destination, currency);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{origin}/{destination}/detailed")
    public HttpEntity<DetailedFare> calculateDetailedFare(@PathVariable("origin") final String origin,
                                          @PathVariable("destination") final String destination,
                                          @RequestParam(value = "currency", defaultValue = "EUR") final String currency) {

        DetailedFare result = facade.calculateDetailedFare(origin, destination, currency);

        return ResponseEntity.ok().body(result);
    }

    // TODO: Add meaningful exception handling
}
