package controllers;

import dtos.GoodToyDto;
import repository.ToyRepository;
import views.ElfView;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = new ToyRepository();
    }

    public void postGoodToy(GoodToyDto goodToyDto) {
        // hará algo con el repositorio
        // si todo ha ido bien devolverá la respuesta
        ElfView.addToyResponse();
    }

}