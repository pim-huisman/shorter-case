package com.klm.cases.df.fare;

import com.klm.cases.df.location.LocationDTO;

public record FareDTO(double amount, Currency currency, LocationDTO origin, LocationDTO destination) {
}
