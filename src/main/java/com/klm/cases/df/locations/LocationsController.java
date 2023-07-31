package com.klm.cases.df.locations;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationsController {
    private final LocationsService service;

    public LocationsController(LocationsService service) {
        this.service = service;
    }

    @GetMapping
    public HttpEntity<PagedModel<EntityModel<Location>>> list() {
        // TODO: test coverage
        // TODO: Add paging support
        // TODO: Add language support
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{key}")
    public HttpEntity<Location> get(@RequestParam(value = "lang", defaultValue = "en") final String lang,
                                    @PathVariable("key") final String key) {
        // TODO: test coverage
        // TODO: Add language support
        return ResponseEntity.ok(service.get(key));
    }

    @GetMapping(params = "term")
    public HttpEntity<PagedModel<EntityModel<Location>>> search(
            @RequestParam(value = "lang", defaultValue = "en") final String lang,
            @RequestParam("term") final String term) {
        // TODO: test coverage
        // TODO: Add paging support
        // TODO: Add language support
        return ResponseEntity.ok(service.search(term));
    }
}
