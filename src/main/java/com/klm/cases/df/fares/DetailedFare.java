package com.klm.cases.df.fares;

import com.klm.cases.df.locations.Location;

public record DetailedFare(Fare fare, Location origin, Location destination) {
}
