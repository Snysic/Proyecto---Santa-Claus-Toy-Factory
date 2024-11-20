package newyearproject.repository;

import newyearproject.db.IDatabase;
import newyearproject.models.BadToy;
import newyearproject.models.GoodToy;
import newyearproject.singletons.BadToyDatabaseSingleton;
import newyearproject.singletons.GoodToyDatabaseSingleton;

@SuppressWarnings("rawtypes")
public class ToyRepository {

    private IDatabase db;

    public void setDB(String type) {
        // setter injection
        if (type == "good_toy")
            this.db = GoodToyDatabaseSingleton.getInstance();

        if (type == "bad_toy")
            this.db = BadToyDatabaseSingleton.getInstance();
    }

    @SuppressWarnings("unchecked")
    public void saveGoodToy(GoodToy toy) {
        db.save(toy);
    }

    @SuppressWarnings("unchecked")
    public void saveBadToy(BadToy toy) {
        db.save(toy);
    }

}