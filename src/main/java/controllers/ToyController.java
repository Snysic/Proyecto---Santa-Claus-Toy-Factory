package controllers;

import dtos.GoodToyDto;
import models.GoodToy;
import repository.ToyRepository;
import views.ElfViewTest;

public class ToyController {
    private final ToyRepository repository;
    private final ElfViewTest view;

    public ToyController(ToyRepository repository, ElfViewTest view) {
        this.repository = repository;
        this.view = view;
    }

    public void postGoodToy(GoodToyDto goodToyDto) {
        GoodToy toy = new GoodToy(
                goodToyDto.title(),
                goodToyDto.brand(),
                goodToyDto.recommendedAge(),
                goodToyDto.category()
        );
        repository.addGoodToy(toy);
        view.addToyResponse();
    }
}