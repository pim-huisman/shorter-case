package com.klm.cases.df.commons;

import org.springframework.beans.factory.annotation.Value;

public class ApiProperties {
    @Value("${travel-api.user.name}")
    private String username;

    @Value("${travel-api.user.password}")
    private String password;

    @Value("${travel-api.url}")
    private String url;

    @Value("${travel-api.path.locations}")
    private String locationsPath;

    @Value("${travel-api.path.fares}")
    private String faresPath;

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String url() {
        return url;
    }

    public String locationsPath() {
        return locationsPath;
    }

    public String faresPath() {
        return faresPath;
    }
}
