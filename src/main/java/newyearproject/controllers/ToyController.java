package newyearproject.controllers;

import newyearproject.dtos.BadToyDto;
import newyearproject.dtos.GoodToyDto;
import newyearproject.models.BadToy;
import newyearproject.models.GoodToy;
import newyearproject.repository.ToyRepository;
import newyearproject.singletons.ToyRepositorySingleton;
import newyearproject.views.ElfView;

import java.util.List;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = ToyRepositorySingleton.getInstance();
    }

    public void postGoodToy(GoodToyDto goodToyDto) {
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

    public void viewGoodToys() {
        repository.setDB("good_toy");
        List<GoodToy> toys = ((List<GoodToy>) repository.getDB().getToys());
        toys.forEach(System.out::println);
    }

    public void viewBadToys() {
        repository.setDB("bad_toy");
        List<BadToy> toys = ((List<BadToy>) repository.getDB().getToys());
        toys.forEach(System.out::println);
    }

    public void saveToysToCSV() {
        System.out.println("The function of saving to CSV is not yet implemented.");
    }
}