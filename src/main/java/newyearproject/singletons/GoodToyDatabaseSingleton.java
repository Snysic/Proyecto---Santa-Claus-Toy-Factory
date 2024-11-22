package newyearproject.singletons;

import newyearproject.db.GoodToyDatabase;
import newyearproject.db.IDatabase;
import newyearproject.models.GoodToy;

public class GoodToyDatabaseSingleton {

    private static IDatabase<GoodToy> INSTANCE;

    private GoodToyDatabaseSingleton() {}

    public static IDatabase<GoodToy> getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GoodToyDatabase();
        }
        return INSTANCE;
    }
}

