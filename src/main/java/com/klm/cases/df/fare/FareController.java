package com.klm.cases.df.fare;

import com.klm.cases.df.location.Location;
import com.klm.cases.df.location.LocationClient;
import com.klm.cases.df.location.LocationMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("fares")
public class FareController {

    private final FareClient fareClient;
    private final LocationClient locationClient;
    private final LocationMapper locationMapper = Mappers.getMapper(LocationMapper.class);

    public FareController(FareClient fareClient, LocationClient locationClient) {
        this.fareClient = fareClient;
        this.locationClient = locationClient;
    }

    @GetMapping("/{origin}/{destination}")
    public FareDTO search(@PathVariable String origin, @PathVariable String destination, @RequestParam("currency") String currency) {
        CompletableFuture<Location> originFuture = CompletableFuture.supplyAsync(() -> locationClient.location(origin));
        CompletableFuture<Location> destinationFuture = CompletableFuture.supplyAsync(() -> locationClient.location(destination));
        CompletableFuture<Fare> fareFuture = CompletableFuture.supplyAsync(() -> fareClient.fare(origin, destination, currency));
        Location locationOrigin = originFuture.join();
        Location locationDestination = destinationFuture.join();
        Fare fare = fareFuture.join();
        return new FareDTO(fare.getAmount(), fare.getCurrency(), locationMapper.toDTO(locationOrigin), locationMapper.toDTO(locationDestination));
    }

}
