package com.klm.cases.df.fare;

import com.klm.cases.df.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "fare", url = "${mock.server.address}", configuration = FeignConfiguration.class)
public interface FareClient {

    @GetMapping(value = "fares/{origin}/{destination}")
    Fare fare(@PathVariable String origin, @PathVariable String destination, @RequestParam("currency") String currency);

}
