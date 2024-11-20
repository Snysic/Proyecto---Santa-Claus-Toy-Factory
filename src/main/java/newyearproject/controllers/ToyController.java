package newyearproject.controllers;

import newyearproject.dtos.BadToyDto;
import newyearproject.dtos.GoodToyDto;
import newyearproject.models.BadToy;
import newyearproject.models.GoodToy;
import newyearproject.repository.ToyRepository;
import newyearproject.singletons.ToyRepositorySingleton;
import newyearproject.mvc.views.ElfView;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = ToyRepositorySingleton.getInstance();
    }

    public void postGoodToy(GoodToyDto goodToyDto) {
        // hará algo con el repositorio
        // si todo ha ido bien devolverá la respuesta
        GoodToy toy = new GoodToy(goodToyDto.title(), true, goodToyDto.brand(), goodToyDto.recommendedAge(), goodToyDto.category());
        repository.setDB("good_toy");
        repository.saveGoodToy(toy);
        ElfView.addToyResponse();
    }

    public void postBadToy(BadToyDto badToyDto) {
        BadToy toy = new BadToy(badToyDto.title(), false, badToyDto.content());
        repository.setDB("bad_toy");
        repository.saveBadToy(toy);
        ElfView.addToyResponse();
    }

}