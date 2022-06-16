package com.example.tour;

import com.example.tour.domain.Domestic;
import com.example.tour.domain.Tour;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<Tour>> {

    @Override
    public EntityModel<Tour> process(EntityModel<Tour> model) {

        model.add(Link.of(model.getRequiredLink("self").getHref() + "/feed").withRel("feed"));

        if(model.getContent() instanceof Domestic)
            model.add(Link.of(model.getRequiredLink("self").getHref() + "/groom").withRel("groom"));

        return model;
    }
}