package newyearproject.singletons;

import newyearproject.repository.ToyRepository;

public class ToyRepositorySingleton {

    private static final ToyRepository INSTANCE = new ToyRepository();

    private ToyRepositorySingleton() {}

    public static ToyRepository getInstance() {
        return INSTANCE;
    }

}
