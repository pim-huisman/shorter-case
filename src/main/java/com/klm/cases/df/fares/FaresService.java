package com.klm.cases.df.fares;

public interface FaresService {
    Fare calculateFare(String origin, String destination, String currency);
}
