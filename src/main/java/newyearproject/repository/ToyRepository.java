package newyearproject.repository;

import newyearproject.db.IDatabase;
import newyearproject.models.Toy;
import newyearproject.models.GoodToy;
import newyearproject.singletons.BadToyDatabaseSingleton;
import newyearproject.singletons.GoodToyDatabaseSingleton;

public class ToyRepository {

    private IDatabase<? extends Toy> db; 

    public void setDB(String type) {
        if (type.equals("good_toy")) {
            this.db = GoodToyDatabaseSingleton.getInstance();
        } else if (type.equals("bad_toy")) {
            this.db = BadToyDatabaseSingleton.getInstance();
        }
    }

    public IDatabase<? extends Toy> getDB() {
        return this.db; 
    }

    public void saveGoodToy(GoodToy toy) {
        if (db instanceof IDatabase<GoodToy>) {
            ((IDatabase<GoodToy>) db).save(toy);
        }
    }

    public void saveBadToy(Toy toy) {
        if (db instanceof IDatabase<Toy>) {
            ((IDatabase<Toy>) db).save(toy);
        }
    }
}