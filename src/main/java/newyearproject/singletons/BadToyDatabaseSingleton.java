package newyearproject.singletons;

import newyearproject.db.BadToyDatabase;
import newyearproject.db.IDatabase;
import newyearproject.models.Toy;

public class BadToyDatabaseSingleton {

    private static IDatabase<Toy> INSTANCE;

    private BadToyDatabaseSingleton() {}

    public static IDatabase<Toy> getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BadToyDatabase();
        }
        return INSTANCE;
    }
}
