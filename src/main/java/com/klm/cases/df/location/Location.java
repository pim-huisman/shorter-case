package com.klm.cases.df.location;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record Location(String code, String name, String description, Coordinates coordinates,
                       com.klm.cases.df.location.Location parent, Set<Location> children) {

}
