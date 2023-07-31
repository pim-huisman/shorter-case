package com.klm.cases.df.locations;

import java.util.Set;

public record Location(String code, String name, String description, Coordinates coordinates, Location parent, Set<Location> children) {
}

record Coordinates(double latitude, double longitude) {
}
