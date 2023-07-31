package com.klm.cases.df.commons;

import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentsBuilderFactory {
    public static UriComponentsBuilder create() {
        // TODO: Externalise config
        return UriComponentsBuilder.fromHttpUrl("http://localhost:8080");
    }
}
