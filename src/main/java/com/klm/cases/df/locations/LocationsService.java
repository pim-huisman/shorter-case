package com.klm.cases.df.locations;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface LocationsService {
    PagedModel<EntityModel<Location>> list();

    Location get(String key);

    PagedModel<EntityModel<Location>> search(String term);
}
