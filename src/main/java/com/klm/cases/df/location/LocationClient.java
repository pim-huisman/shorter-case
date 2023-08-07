package com.klm.cases.df.location;

import com.klm.cases.df.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "location", url = "${mock.server.address}", configuration = FeignConfiguration.class)
public interface LocationClient {

    @GetMapping(value = "airports")
    PagedModel<EntityModel<Location>> locations(@RequestParam("term") String searchTerm);

    @GetMapping(value = "airports/{code}")
    Location location(@PathVariable String code);

}
