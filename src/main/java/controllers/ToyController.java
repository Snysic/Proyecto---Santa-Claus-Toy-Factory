package controllers;

import dtos.GoodToyDto;
import models.GoodToy;
import repository.ToyRepository;
import views.ElfViewTest;

public class ToyController {
    private final ToyRepository repository;

    public ToyController() {
        this.repository = new ToyRepository();
    }

    public void postGoodToy(GoodToyDto goodToyDto) {
        GoodToy toy = new GoodToy(
                goodToyDto.title(),
                goodToyDto.brand(),
                goodToyDto.recommendedAge(),
                goodToyDto.category()
        );
        repository.addGoodToy(toy);
        ElfViewTest.addToyResponse();
    }
}