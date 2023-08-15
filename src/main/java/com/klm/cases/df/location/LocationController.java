package com.klm.cases.df.location;

import org.mapstruct.factory.Mappers;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {

    private final LocationMapper locationMapper;
    private final LocationClient client;

    public LocationController(LocationClient client) {
        this.client = client;
        locationMapper = Mappers.getMapper(LocationMapper.class);
    }

    @GetMapping()
    public List<LocationDTO> search(@RequestParam String term) {
        return locationMapper.toDTOs(client.locations(term).getContent().stream().map(EntityModel::getContent).toList());
    }

}
