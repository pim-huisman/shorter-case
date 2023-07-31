package com.klm.cases.df.fares;

public interface FaresFacade {
    Fare calculateFare(String origin, String destination, String currency);

    DetailedFare calculateDetailedFare(String origin, String destination, String currency);
}
